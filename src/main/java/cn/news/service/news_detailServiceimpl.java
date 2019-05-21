package cn.news.service;

import cn.news.dao.news_detailMapper;
import cn.news.pojo.news_category;
import cn.news.pojo.news_detail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("news_detailService")
public class news_detailServiceimpl implements  news_detailService{

    @Resource
    private news_detailMapper news_detailMapper;

    @Override
    public List<news_detail> getdetailList(String title, Integer categoryId) {
        return news_detailMapper.getdetailList(title,categoryId);
    }

    @Override
    public news_detail getdetailByid(Integer id) {
        return news_detailMapper.getdetailByid(id);
    }

    @Override
    public List<news_category> getcategoryList() {
        return news_detailMapper.getcategoryList();
    }

    @Override
    public int getdetailCountByid(String title) {
        return news_detailMapper.getdetailCountByid(title);
    }

    @Override
    public int updatedetailByid(news_detail news_detail) {
        return news_detailMapper.updatedetailByid(news_detail);
    }
}
