package cn.news.controller;

import cn.news.pojo.news_category;
import cn.news.pojo.news_detail;
import cn.news.service.news_detailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class newsController {

    @Resource
    private news_detailService news_detailService;


    /***
     *
     * @param model
     * @param title 标题
     * @param categoryId 分类id
     * @return
     */
    @RequestMapping("/newslist")
    public String QuerydetailList(Model model,@RequestParam(value = "title",required = false) String title,@RequestParam(value = "categoryId",required = false) Integer categoryId){
        List<news_category> news_categoryList = news_detailService.getcategoryList();
        List<news_detail> news_detailList = news_detailService.getdetailList(title,categoryId);
        model.addAttribute("news_categoryList",news_categoryList);
        model.addAttribute("news_detailList",news_detailList);
        model.addAttribute("title",title);
        model.addAttribute("categoryId",categoryId);
        return "newslist";
    }

    /***
     *
     * @param model
     * @param id 新闻编号
     * @return
     */
    @RequestMapping("update/{id}")
    public String update(Model model,@PathVariable(value = "id")Integer id){
        List<news_category> news_categoryList = news_detailService.getcategoryList();
        news_detail news_detail = news_detailService.getdetailByid(id);
        model.addAttribute("news_categoryList",news_categoryList);
        model.addAttribute("news_detail",news_detail);
        return "newsupdate";
    }

    /***
     *
     * @param news_detail 修改后传上来的数据
     * @return
     */
    @RequestMapping("newsupdate")
    public String newsupdate(news_detail news_detail){
        news_detail.setUpdateDate(new Date());
        int i = news_detailService.updatedetailByid(news_detail);
        if(i > 0){
            return "redirect:/news/newslist";
        }else{
            return "";
        }
    }
}
