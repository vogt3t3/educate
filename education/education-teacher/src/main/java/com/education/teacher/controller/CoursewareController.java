package com.education.teacher.controller;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.Courseware;
import com.education.model.CoursewareResId;
import com.education.model.ResultDo;
import com.education.service.ICoursewareService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;

/**
 * 课件资源的控制层 该模块是对资源下的课件 进行增 删 操作
 * @author 申忠正
 */
@Controller
@RequestMapping("/api/teacher")
public class CoursewareController {

    /**
     * 注入导学资源的业务层
     */
    @Reference
    private ICoursewareService coursewareService;
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(CoursewareController.class.getName());
    /**
     * 根据资源id查询所对应的课件(如果资源id为空，则查询所有课件资源)
     * 
     * @return List
     * @throws Exception
     */
    @ApiOperation(notes = "CoursewareController/queryCourseware", httpMethod = "GET", value = "查询所有的课件资源信息")
    @RequestMapping("/CoursewareController/queryCourseware")
    @ResponseBody
    public ResultDo<Object> queryCourseware(int pageNum, int pageSize, int resourceId) throws Exception {
        logger.info("query课件资源的控制层");
        PageInfo<Courseware> page = coursewareService.queryCourseware(resourceId, pageNum, pageSize);
        List<Courseware> coursewareList = page.getList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", coursewareList);
        map.put("total", page.getTotal());
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResData(map);
        return res;
}
    @RequestMapping("/queryCourseware")
    public void queryCourseware() throws Exception {
        System.out.println("query课件资源的控制层");
        // 资源id(resourceId),当前页 每页记录数
        PageInfo<Courseware> pro = coursewareService.queryCourseware(2, 1, 2);
        List<Courseware> CoursewareList = pro.getList();

        int i = 1;
        for (Courseware Courseware : CoursewareList) {
            System.out.println(Courseware.getCoursewareName() + i);
            i++;
        }
    }

    /**
     * 删除课件资源 根据传过来的课件id 删除相应的记录
     * 删除课件资源
     */
    @ApiOperation(notes = "CoursewareController/deleteCourseware", httpMethod = "GET", value = "删除课件资源信息")
    @RequestMapping("/CoursewareController/deleteCourseware")
    @ResponseBody
    public ResultDo<Object> deleteResource(int coursewareId) throws Exception {
        logger.info("del课件资源的控制层");
        logger.info("课件id" + coursewareId);
        // del课件资源（传入一个资源id）
        //int coursewareId = 2;       
        int result = coursewareService.deleteCourseware(coursewareId);
        logger.info("教师/课件删除 控制层");
        logger.info("result = " + result);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResMsg("删除成功！");
        return res;
    }

    /**
     * 课件的添加 文件上传下载
     * 
     * @param courseware
     *            传入课件对象
     * @return 影响的行数 =1成功
     */
    /*
     * @ApiOperation(notes = "StudyResController/coursewareAdd", httpMethod =
     * "POST", value = "增加课件资源信息")
     * 
     * @RequestMapping("/StudyResController/coursewareAdd")
     * 
     * @ResponseBody public ResultDo<Object> coursewareAdd(@RequestBody
     * CoursewareResId courseware){ //执行添加操作！ 注意 ： serviceImpl中使用的是模拟数据！！！
     * logger.info(courseware.getResourceId() + " **********"); int result =
     * coursewareService.coursewareAdd(courseware); ResultDo<Object> res =new
     * ResultDo<Object>(); res.setResCode(0); res.setResMsg("添加成功"); return
     * res; @RequestBody CoursewareResId courseware, }
     */

    /*
     * @ApiOperation(notes = "StudyResController/coursewareAdd", httpMethod =
     * "POST", value = "增加课件资源信息")
     */
    @RequestMapping("/CoursewareController/coursewareAdd")
    @ResponseBody
    public ResultDo<Object> coursewareAdd(CoursewareResId courseware, @RequestParam(value = "file") MultipartFile file,
            HttpSession session) {
        // System.out.println(courseware.getResourceId() + " **********");
        // System.out.println(courseware.getCoursewareName() + " **********");
        // 视频存放的路径
        String path = session.getServletContext().getRealPath("myFiles");
        String fileName = file.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 存入数据库的路径
        String coursewarePath = "myFiles" + "/" + fileName;
        courseware.setCoursewarePath(coursewarePath);
        int result = coursewareService.coursewareAdd(courseware);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResMsg("添加成功");
        return res;
    }

}