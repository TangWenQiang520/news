package cn.news.dao;

import cn.news.pojo.news_category;
import cn.news.pojo.news_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface news_detailMapper {
    /***
     * 查询所有新闻信息
     * @param title 标题
     * @param categoryId 分类id
     * @return
     */
    List<news_detail> getdetailList(@Param("title") String title, @Param("categoryId") Integer categoryId);

    /***
     * 按id查询
     * @param id 新闻编号
     * @return
     */
    news_detail getdetailByid(@Param("id") Integer id);

    /***
     * 查询所有的分类信息
     * @return
     */
    List<news_category> getcategoryList();

    /***
     * 按标题查询
     * @param title 标题
     * @return
     */
    int getdetailCountByid(@Param("title") String title);

    /***
     * 修改
     * @param news_detail 新闻信息
     * @return
     */
    int updatedetailByid(news_detail news_detail);
}