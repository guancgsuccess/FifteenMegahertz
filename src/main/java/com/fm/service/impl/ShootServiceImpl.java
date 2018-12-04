package com.fm.service.impl;

import com.fm.dao.ShootDao;
import com.fm.entity.Shoot;
import com.fm.entity.shoot.PageModel;
import com.fm.service.ShootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangpeng
 */
@Service
public class ShootServiceImpl implements ShootService {
    private final ShootDao mapper;

    @Autowired
    public ShootServiceImpl(ShootDao mapper){this.mapper=mapper;}

    @Override
    public Integer deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(Shoot entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public Integer save(Shoot entity) {
        return mapper.insert(entity);
    }

    @Override
    public List<Shoot> findAll() {
        return mapper.selectByExample(null);
    }

    @Override
    public Shoot findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据套餐分类Id获得所有类别
     * @param shootThemeId 套餐分类Id
     * @return
     */
    public List<Shoot> selectAllById(Integer shootThemeId){
        return mapper.selectAllById(shootThemeId);
    }

    /**
     * 获得当前页的所有套餐
     * @param pagecode 当前页码
     * @param page 分页
     * @param themeId 套餐分类Id
     * @return 返回所有套餐
     */
    @Override
    public PageModel<Shoot> getAllByPage(Integer pagecode, PageModel<Shoot> page, Integer themeId) {
        if (pagecode==null){
            page.setCurrentPageCode(1);
        }else {
            page.setCurrentPageCode(pagecode);
        }
        page.setTotalRecord(this.mapper.getCount(themeId));
        page.setTotalPages(page.getTotalRecord()%page.getPageSize()==0?page.getTotalRecord()/page.getPageSize():page.getTotalRecord()/page.getPageSize()+1);
        page.setStartRecord((page.getCurrentPageCode()-1)*page.getPageSize());
        page.setModelList(mapper.getAllByPage(page,themeId));
        return page;
    }

    @Override
    public Integer getCount(Integer themeId) {
        return mapper.getCount(themeId);
    }

    @Override
    public Integer getLocCount(String shootLoc) {
        return mapper.getLocCount(shootLoc);
    }

    /**
     * 根据地点获得所有套餐
     * @param pagecode 当前页
     * @param page 分页
     * @param shootLoc 集合地点
     * @return 返回当前页所有套餐
     */
    @Override
    public PageModel<Shoot> getAllByLoc(Integer pagecode, PageModel<Shoot> page, String shootLoc) {
            if (pagecode==null){
                page.setCurrentPageCode(1);
            }else {
                page.setCurrentPageCode(pagecode);
            }
            page.setTotalRecord(mapper.getLocCount(shootLoc));
            page.setTotalPages(page.getTotalRecord()%page.getPageSize()==0?page.getTotalRecord()/page.getPageSize():page.getTotalRecord()/page.getPageSize()+1);
            page.setStartRecord((page.getCurrentPageCode()-1)*page.getPageSize());
            page.setModelList(mapper.getAllByLoc(page,shootLoc));

        return page;
    }

    public Map<String,Object> selectById(Integer shootId){
        Map<String,Object> map = new HashMap();
        List<Object> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Shoot shoot = mapper.selectByPrimaryKey(shootId);
        //套餐描述
        map.put("shootDesc",shoot.getShootDesc());
        //套餐价格
        map.put("shootPrice",shoot.getShootPrice());
        //集合地点
        map.put("shootLoc",shoot.getShootLoc());
        //套餐对应图片
        map.put("img2Path",shoot.getImg2Path());
        map.put("img3Path",shoot.getImg3Path());
        map.put("img4Path",shoot.getImg4Path());
        map.put("img5Path",shoot.getImg5Path());
        map.put("img6Path",shoot.getImg6Path());
        map.put("img7Path",shoot.getImg7Path());
        map.put("img8Path",shoot.getImg8Path());

        list.add(map);
        map1.put("shootList",list);
        return map1;
    }
}
