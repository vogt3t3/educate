package com.education.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.MvideoQuizDao;
import com.education.model.StudentQuizModel;
import com.education.model.TeacherReplyModel;
import com.education.service.MvideoQuizService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 视频疑问
 *
 */
@Service
public class MvideoQuizServiceImpl implements MvideoQuizService {
    /**
     * 视频疑问的接口
     */
    @Autowired
    private MvideoQuizDao md;

    @Override
    public PageInfo<StudentQuizModel> mvpage(Integer pageNo, Integer pageSiz) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSiz = pageSiz == null ? 5 : pageSiz;
        PageHelper.startPage(pageNo, pageSiz);
        List<StudentQuizModel> list = md.seleVideoQuiz();
        PageInfo<StudentQuizModel> page1 = new PageInfo<StudentQuizModel>(list);
        return page1;
    }

    @Override
    public PageInfo<StudentQuizModel> mhone(String tr, Integer lx, Integer pageNo, Integer pageSiz) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSiz = pageSiz == null ? 5 : pageSiz;
        PageHelper.startPage(pageNo, pageSiz);
        if(lx!=null){
            if (lx == 1) {
                int i = Integer.parseInt(tr);
                System.out.println(i);
                List<StudentQuizModel> list = md.seleQuizint(i);
                PageInfo<StudentQuizModel> p = new PageInfo<StudentQuizModel>(list);
                return p;
            }
            else {
                List<StudentQuizModel> list1 = md.seleMhoneVideoQuiz("%" + tr + "%");
                PageInfo<StudentQuizModel> p1 = new PageInfo<StudentQuizModel>(list1);
                System.out.println(tr);
                return p1;
            }
        }
        List<StudentQuizModel> list = md.seleVideoQuiz();
        PageInfo<StudentQuizModel> page1 = new PageInfo<StudentQuizModel>(list);
        return page1;
    }

    @Override
    public void updateVideoQuiz(Integer teid, Integer reid, Integer quid, String reco) throws Exception {
        TeacherReplyModel tl = new TeacherReplyModel();
        tl.setTeacherId(teid);
        tl.setReplyId(reid);
        tl.setQuizid(quid);
        tl.setReplyContent(reco);
        Date d = new Date();
        tl.setReplyTime(d);
        tl.setReplyDelete(1);
        md.updateVideoQuiz(tl);

    }

    @Override
    public int delevoide(Integer qid) throws Exception {
        md.delVideoQuiz(qid);
        return 0;
    }

}
