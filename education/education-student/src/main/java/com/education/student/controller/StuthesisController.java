/**
 * 
 */
package com.education.student.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.ThesisLayoutModel;
import com.education.model.ThesisModel;
import com.education.service.IStuthesisService;
import com.education.util.PropertiesUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生端论文控制层
 * 
 * @author 周长磊
 *
 */
@Api(value = "/api/student")
@RestController
@RequestMapping("/api/student")
public class StuthesisController {

    /**
     * 日志记录类
     */
    private static Logger LOGGER = LogManager.getLogger(StudentController.class.getName());

    /**
     * 学生端论文服务层接口
     */
    @Reference
    private IStuthesisService istuthesisService;

    /**
     * 获取论文规范
     * 
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return ResultDo<Object> 分页实体
     * @throws Exception
     *             抛出异常
     */
    @ApiOperation(notes = "listThesisLayout", httpMethod = "GET", value = "获取论文")
    @RequestMapping(value = "/listThesisLayout", method = RequestMethod.GET)
    public ResultDo<Object> listThesisLayout(Integer pageNo, Integer pageSize) throws Exception {

        // 返回查询结果
        PageInfo<ThesisLayoutModel> pageInfo = istuthesisService.listThesisLayout(pageNo, pageSize);

        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (pageInfo.getList().size() > 0) {
            rs.setResData(pageInfo);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("请求成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("没有该数据");
        }
        LOGGER.info(rs);

        return rs;
    }

    /**
     * 获取论文
     * 
     * @param studentId
     *            学生编号
     * @param session
     *            获取session
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return ResultDo<Object> 分页实体
     * @throws Exception
     *             抛出异常
     */
    @ApiOperation(notes = "listThesis", httpMethod = "GET", value = "获取论文")
    @RequestMapping(value = "/listThesis", method = RequestMethod.GET)
    public ResultDo<Object> listThesis(Integer studentId, HttpSession session, Integer pageNo, Integer pageSize)
            throws Exception {
        System.out.println(session.getAttribute("stuId")+"---------------");
        studentId = (Integer) session.getAttribute("stuId");

        // 返回查询结果
        PageInfo<ThesisModel> pageInfo = istuthesisService.listThesis(studentId, pageNo, pageSize);

        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (pageInfo.getList().size() > 0) {
            rs.setResData(pageInfo);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("请求成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("没有该数据");
        }
        LOGGER.info(rs);

        return rs;
    }

    /**
     * 提交论文（上传功能）
     * 
     * @param file
     *            路径
     * @param session
     *            获取session数据
     * @return ResultDo<Object> 分页实体
     * @throws Exception
     *             抛出异常
     */
    @ApiOperation(notes = "saveThesis", httpMethod = "POST", value = "提交论文")
    @RequestMapping(value = "/saveThesis", method = RequestMethod.POST)
    public ResultDo<Object> saveThesis(MultipartFile file, HttpSession session) throws Exception {

        ThesisModel th = new ThesisModel();
        // 获取用户编号
        th.setStudentId((Integer) session.getAttribute("stuId"));

        // 获取文件名
        String fileName = file.getOriginalFilename();
        th.setThesisTitle(fileName);

        // 复制文件
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                new File(PropertiesUtil.doc + File.separator + fileName));

        // 存入数据库的路径
        String realpath = "doc" + File.separator + fileName;
        th.setThesisAddress(realpath);

        // 返回查询结果
        int record = istuthesisService.saveThesis(th);
        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (record > 0) {
            rs.setResData(record);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("添加成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("添加失败");
        }
        LOGGER.info(rs);

        return rs;
    }

    /**
     * 下载功能
     * 
     * @param fileName
     *            路径
     * @param response
     *            向客户端发送数据
     * @return ResultDo<Object>
     * @throws IOException
     *             抛出异常
     */
    @ApiOperation(notes = "download", httpMethod = "GET", value = "下载")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResultDo<Object> downLoad(String fileName, HttpServletResponse response)
            throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        OutputStream os = response.getOutputStream();
        os.write(FileUtils.readFileToByteArray(new File(PropertiesUtil.download + File.separator + fileName)));
        // 这里主要关闭
        os.close();

        return null;
    }

    /**
     * 下载功能
     * 
     * @param fileName
     *            路径
     * @param request
     *            与客户端交互
     * @return ResponseEntity<byte[]>
     * @throws IOException
     *             抛出异常
     */
    @RequestMapping("/down2")
    public ResponseEntity<byte[]> download(String fileName, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("myFiles");
        File file = new File(path + "/" + fileName);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + fileName);
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        System.out.println(entity);

        return entity;
    }

}
