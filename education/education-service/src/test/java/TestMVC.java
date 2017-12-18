
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ExamMessageModel;
import com.education.model.User;
import com.education.service.IUserService;
import com.education.service.MvideoQuizService;
import com.education.service.QueryExamPage;
import com.education.util.DateUtil;
import com.github.pagehelper.PageInfo;

/**
 * SpringNVC测试
 * 
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring.xml" })
public class TestMVC {
    /**
     * 数据处理层接口
     */
    @Autowired
	private IUserService userservice;
	
	/**+
	 * 
	 */
	@Autowired
	private QueryExamPage qp;
	/*@Autowired
    private DateUtil du;*/
	@Autowired
    private  MvideoQuizService mq;
	/**
	 * junit测试类
	 * 
	 * @throws Exception
	 *             异常抛出
	 */
	
	/*  @Test
	 public void fenYe() throws Exception { PageInfo<User>
	 list=userservice.queryByPage("lisi", 1, 5);
	 System.out.println(list.getList()); }
	 */

/*	@Test
	public void tt() throws Exception {
		System.out.println("---");
	 
	    System.out.println("++++");
	    PageInfo<ExamMessageModel> pro=qp.pagenow(1,2);
		 List<ExamMessageModel> list=pro.getList();
		 for (ExamMessageModel el : list) {
			 System.out.println("课程id"+el.getExamdelete());
			 System.out.println("考试id"+el.getExamid());
			 System.out.println("考试地点"+el.getExamplace());
			 System.out.println("考试时间"+el.getExamtime());
			 System.out.println(el.getExamform());
		}
	}*/
	 /**
	  * 测试加入
	 * @throws Exception
	 */
/*	@Test
	  public void cc() throws Exception{
		DateUtil du=new DateUtil();
		 ExamMessageModel el= new ExamMessageModel();
	  el.setCourseid(1);
	  el.setTeacherid(6);
	  el.setExamplace("黄土高坡");
	  Date  t1=DateUtil.formatString("2015-5-5","yyyy-MM-dd");
	  el.setExamtime(t1);
	  
	  Date  t2=DateUtil.formatString("2015-6-5","yyyy-MM-dd");
	  el.setExamappointtime(t2);
	  
	  el.setExamform("网上考试");
	  Date  t3=DateUtil.formatString("2015-6-6","yyyy-MM-dd");
	  el.setExamaddtime(t3);
	  el.setExammotifyperson(0);
	  Date  t4=DateUtil.formatString("2015-6-6","yyyy-MM-dd");
	  el.setExammotifydate(t4);
	  el.setExamdelete(1);
	  qp.addexam(el);
	}*/
	
/*     @Test
     public void dd() throws Exception{
    	 DateUtil du=new DateUtil();
    	 Date  asd=du.formatString("2055-5-5","yyyy-MM-dd");
    	 System.out.println("-----------------"+asd);
    	 String nnn=du.formatDate(asd, "yyyy-MM-dd");
    	 System.out.println(nnn);
     }*/
	/*@Test
      public  void ff() throws Exception{
    	  mq.mhone(1,"",1,5);
      }*/
}
