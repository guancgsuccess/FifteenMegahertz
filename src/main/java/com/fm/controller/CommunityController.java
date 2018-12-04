package com.fm.controller;

import com.alibaba.fastjson.JSON;
import com.fm.entity.*;
import com.fm.service.*;
import com.fm.util.community.Container;
import com.fm.util.community.Page;
import com.fm.util.community.UploadImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("community")
@SuppressWarnings("all")
public class CommunityController {

    @Autowired
    private CommunityActivityService communityActivityService;

    @Autowired
    private CommunityBulletinService communityBulletinService;

    @Autowired
    private CommunityMessageService communityMessageService;

    @Autowired
    private CommunityMembersService communityMembersService;

    @Autowired
    private CommunityCommentService communityCommentService;

    @Autowired
    private CommunityService communityService;

    /*******************************************社区部分*********************************************************/

    /**
     * 获得最新几条社区留言信息用于首页展示
     *
     * @return json格式封装好的社区留言信息
     */
    @GetMapping("get/nComm")
    public Map<String, Object> getCustomerCommunity() {

        Map<String, Object> commMap = communityService.selectCommunityByNew();
        return commMap;
    }

    /**
     * 分页获取全部社区列表
     *
     * @param page 页码
     * @return 全部社区信息分页集合
     */
    @GetMapping("get/allComm/{page}")
    public Map<String, Object> getAllCommunity(@PathVariable Integer page) {

        Page<Community> pageModel = new Page<>();
        pageModel.setCurrentPage(page == null ? 1 : page);
        pageModel.setPageSize(6);

        Map<String, Object> commMap = communityService.selectAllCommunityByPage(pageModel);
        return commMap;
    }

    /**
     * 分页获得我的社区信息集合
     *
     * @param session session 为了获取用户id
     * @param page    页码
     * @return 封装好的社区信息
     */
    @GetMapping("get/myComm/{page}")
    public Map<String, Object> getMyCommunity(HttpSession session, @PathVariable Integer page) {

        Page<Community> pageModel = new Page<>();
        pageModel.setCurrentPage(page == null ? 1 : page);
        pageModel.setPageSize(100);

        Map<String, Object> commMap = communityService.selectCommunityByCustId
                (pageModel, (Integer) session.getAttribute("custId"));
        return commMap;
    }

    /**
     * 获得社区详情信息
     *
     * @param session 从session获取用户id 社区id 或者 留言信息id
     * @return 封装好的社区信息集合
     */
    @GetMapping("get/commInfo")
    public Map<String, Object> getCommunityInfo(HttpSession session) {

        Integer custId = (Integer) session.getAttribute("custId");
        String commId = (String) session.getAttribute("commId");
        String messId = (String) session.getAttribute("messId");

        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("status", 0);

        if (commId != null) {
            Map<String, Object> commMap = communityService.selectCommunityById(commId, custId);
            if (commMap != null) {
                infoMap.put("status", 1);
                infoMap.put("commInfo", commMap);
            }
        } else if (messId != null) {
            Map<String, Object> commMapByMess = communityService.selectCommunityByMessageId(messId, custId);
            if (commMapByMess != null) {
                infoMap.put("status", 1);
                infoMap.put("commInfo", commMapByMess);
            }
        }
        return infoMap;
    }

    /**
     * 删除我的社区
     *
     * @param commId 社区id
     * @return 返回状态码
     */
    @GetMapping("del/myComm/{commId}")
    public Map<String, Object> delMyCommunity(@PathVariable Integer commId) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (commId == null)
            return messMap;

        if (communityService.deleteCommunity(commId) > 0)
            messMap.put("status", 1);

        return messMap;
    }

    /**
     * 添加新的社区
     *
     * @param session session中的用户id
     * @param mess    前端表单数据
     * @return 状态码
     */
    @PostMapping("add/comm")
    public Map<String, Object> postImg(HttpSession session, @RequestBody String mess) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        Map<String, Object> map = (Map<String, Object>) JSON.parse(mess);
        Community community = new Community();
        community.setCommunityName((String) map.get("communityName"));
        community.setCategoryId(Integer.parseInt((String) map.get("categoryId")));
        community.setCommunityLabel((String) map.get("communityLabel"));
        community.setCommunityPhoto((String) map.get("communityPhoto"));
        community.setCustId((Integer) session.getAttribute("custId"));

        if (communityService.addCommunity(community) > 0) {
            messMap.put("status", 1);
        }

        return messMap;
    }

    /**
     * 查询社区名字是否存在
     *
     * @param commName 社区名字
     * @return 状态码
     */
    @GetMapping("get/presence/{commName}")
    public Map<String, Object> getCommName(@PathVariable String commName) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        if (communityService.selectCommunityNameByName(commName)) {
            map.put("status", 1);
        }
        return map;
    }

    /**
     * 获得上传图片token
     *
     * @param key 图片key
     * @return token
     */
    @GetMapping("get/token/{key}")
    public Map<String, Object> getToken(@PathVariable String key) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", UploadImg.get15MQiniuToken(key));
        return map;
    }

    /*******************************************社区活动部分*********************************************/

    /**
     * 分页获得全部活动信息
     *
     * @param underway 进行状态 0全部 1正在进行
     * @param page     页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/allActivity/{underway}/{page}")
    public Map<String, Object> getActivityByPage(@PathVariable Integer underway, @PathVariable Integer page) {

        Page<CommunityActivity> pageModel = new Page<>();
        if (null == page)
            page = 1;
        pageModel.setCurrentPage(page);
        pageModel.setPageSize(6);
        Map<String, Object> activityPageMap = communityActivityService.selectCommunityActivityByPage(pageModel, underway);
        return activityPageMap;
    }

    /**
     * 获得社区
     *
     * @return 封装好的数据集合
     */
    @GetMapping("get/activity")
    public Map<String, Object> getActivity() {

        return Container.activityContainer(null);
    }

    /**
     * 获得正在进行的社区
     *
     * @return 封装好的数据集合
     */
    @GetMapping("get/underwayActivity")
    public Map<String, Object> underwayActivity() {

        return Container.underwayActivityContainer(null);
    }

    /*******************************************社区公告部分*********************************************/

    /**
     * 分页获得全部公告信息
     *
     * @param page 页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/allBulletin/{page}")
    public Map<String, Object> getBulletinByPage(@PathVariable Integer page) {

        Page<CommunityBulletin> pageModel = new Page<>();
        if (null == page)
            page = 1;
        pageModel.setCurrentPage(page);
        pageModel.setPageSize(5);
        Map<String, Object> bulletinPageMap = communityBulletinService.selectCommunityBulletinByPage(pageModel);
        return bulletinPageMap;
    }

    /**
     * 获得公告信息详情
     *
     * @param session 从session中获得公告id
     * @return 封装好的数据集合
     */
    @GetMapping("get/bulletinInfo")
    public Map<String, Object> getBulletinInfo(HttpSession session) {

        String bulletinId = null;

        if (session.getAttribute("bulletinId") != null) {
            //获取公告id
            bulletinId = (String) session.getAttribute("bulletinId");
            //用完就删除
            session.removeAttribute("bulletinId");
        }

        Map<String, Object> bulletinInfoMap = new HashMap<>();
        bulletinInfoMap.put("status", 0);

        if (bulletinId == null || bulletinId.equals(""))
            return bulletinInfoMap;

        Map<String, Object> bulletinMaps = communityBulletinService.selectByPrimaryKey(Integer.parseInt(bulletinId));

        if (bulletinMaps != null) {
            bulletinInfoMap.put("status", 1);
            bulletinInfoMap.put("bulletinInfo", bulletinMaps);
        }

        return bulletinInfoMap;
    }

    /*******************************************社区评论部分*********************************************/

    /**
     * 分页获得留言信息的全部评论
     *
     * @param messId 信息id
     * @param page   页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/allComment/{messId}/{page}")
    public Map<String, Object> getAllComment(@PathVariable Integer messId, @PathVariable Integer page) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (messId != null) {
            Page<CommunityComment> pageModel = new Page<>();
            pageModel.setCurrentPage(page == null ? 1 : page);
            pageModel.setPageSize(6);
            Map<String, Object> commentMap = communityCommentService.selectCommentByMessageId(pageModel, messId);
            if (commentMap != null) {
                return commentMap;
            }
        }
        return messMap;
    }

    /**
     * 添加评论或回复
     *
     * @param commentStr 表单内容
     * @return 状态码
     */
    @PostMapping("add/reply")
    public Map<String, Object> addComment(@RequestBody String commentStr) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        Map<String, Object> map = (Map<String, Object>) JSON.parse(commentStr);
        CommunityComment communityComment = new CommunityComment();
        communityComment.setMessageId(Integer.parseInt((String) map.get("messageId")));
        communityComment.setSuperCommentId(map.get("superCommentId") == null ? null :
                (map.get("superCommentId").equals("") ? null : Integer.parseInt((String) map.get("superCommentId"))));
        communityComment.setCustId((Integer) map.get("custId"));
        communityComment.setCommentContent((String) map.get("commentContent"));

        if (communityComment != null) {
            if (communityCommentService.addCommunityComment(communityComment) > 0) {
                messMap.put("status", 1);
            }
        }

        return messMap;
    }

    /*******************************************社区人员部分*********************************************/

    /**
     * 获得用户已加入的社区用于展示
     *
     * @param custId 用户id
     * @return 封装好的数据集合
     */
    @GetMapping("get/cc/{custId}")
    public Map<String, Object> getCustComms(@PathVariable Integer custId) {

        Map<String, Object> custCommMap = communityMembersService.selectCommunityByCustomerId(custId);
        return custCommMap;
    }

    /**
     * 分页查询社区内的人员
     *
     * @param commId 社区id
     * @param page   页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/commCust/{commId}/{page}")
    public Map<String, Object> getCustByCommunit(@PathVariable Integer commId, @PathVariable Integer page) {

        Page<CommunityMembers> pageModel = new Page<>();
        pageModel.setCurrentPage(page == null ? 1 : page);
        pageModel.setPageSize(2);

        Map<String, Object> commMap = communityMembersService.selectCustByCommunityId(pageModel, commId);
        return commMap;
    }

    /**
     * 加入该社区
     *
     * @param commId 社区id
     * @param custId 用户id
     * @return 状态码
     */
    @GetMapping("join/comm/{commId}/{custId}")
    public Map<String, Object> postJoinCommunity(@PathVariable String commId, @PathVariable Integer custId) {

        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("status", 0);

        if (commId != null && custId != null) {
            int status = communityMembersService.addCommunityMembers(commId, custId);
            if (status > 0) {
                Map<String, Object> commMap = communityService.selectCommunityById(commId, custId);
                if (commMap != null) {
                    infoMap.put("status", 1);
                    infoMap.put("commInfo", commMap);
                }
            }
        }
        return infoMap;
    }

    /**
     * 退出该社区
     *
     * @param commId 社区id
     * @param custId 用户id
     * @return 封装好的数据集合
     */
    @GetMapping("exit/comm/{commId}/{custId}")
    public Map<String, Object> delExitCommunity(@PathVariable String commId, @PathVariable Integer custId) {

        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("status", 0);

        if (commId != null && custId != null) {
            int status = communityMembersService.deleteCommunityMembers(commId, custId);
            if (status > 0) {
                Map<String, Object> commMap = communityService.selectCommunityById(commId, custId);
                if (commMap != null) {
                    infoMap.put("status", 1);
                    infoMap.put("commInfo", commMap);
                }
            }
        }

        return infoMap;
    }

    /**
     * 拉黑或解除该用户
     *
     * @param commId 社区id
     * @param custId 用户id
     * @param tip    状态码 0 拉黑 1 解除
     * @return 状态码
     */
    @GetMapping("upd/custStatus/{commId}/{custId}/{tip}")
    public Map<String, Object> updCustStatus
    (@PathVariable Integer commId, @PathVariable Integer custId, @PathVariable Integer tip) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (tip == null || commId == null || custId == null)
            return messMap;

        CommunityMembers communityMembers = new CommunityMembers();
        communityMembers.setCustId(custId);
        communityMembers.setCommunityId(commId);
        communityMembers.setCustStatus(tip);

        if (communityMembersService.updateCommunityMembersStatus(communityMembers) > 0)
            messMap.put("status", 1);
        return messMap;
    }

    /*******************************************社区信息部分*********************************************/

    /**
     * 查询前n条留言信息
     *
     * @return 封装好的数据集合
     */
    @GetMapping("get/nMess")
    public Map<String, Object> getTwoMonthMessage() {

        Map<String, Object> messMap = communityMessageService.selectNCommunityMessage(6);
        return messMap;
    }

    /**
     * 分页获得社区的全部信息
     *
     * @param session session中的用户id
     * @param commId  社区id
     * @param page    页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/allMess/{commId}/{page}")
    public Map<String, Object> getAllMess(HttpSession session
            , @PathVariable Integer commId, @PathVariable Integer page) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (commId != null) {
            Page<CommunityMessage> pageModel = new Page<>();
            pageModel.setCurrentPage(page == null ? 1 : page);
            pageModel.setPageSize(6);
            Map<String, Object> commInfoMap = communityMessageService.selectMessageByCommunityId
                    (pageModel, commId, (Integer) session.getAttribute("custId"));
            if (commInfoMap != null) {
                return commInfoMap;
            }
        }
        return messMap;
    }

    /**
     * 分页获得我发表的信息
     *
     * @param session session中的用户id
     * @param page    页码
     * @return 封装好的数据集合
     */
    @GetMapping("get/myMess/{page}")
    public Map<String, Object> getAllMess(HttpSession session, @PathVariable Integer page) {

        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (session.getAttribute("custId") != null) {
            Page<CommunityMessage> pageModel = new Page<>();
            pageModel.setCurrentPage(page == null ? 1 : page);
            pageModel.setPageSize(3);
            Map<String, Object> messageMap = communityMessageService.selectMessageByCustId
                    (pageModel, (Integer) session.getAttribute("custId"));
            if (messageMap != null) {
                return messageMap;
            }
        }
        return messMap;
    }

    /**
     * 添加新的信息
     *
     * @param session  session中获得用户id
     * @param messJson 信息数据
     * @return 状态码
     */
    @PostMapping("add/mess")
    public Map<String, Object> addMessage(HttpSession session, @RequestBody String messJson) {

        Map<String, Object> map = (Map<String, Object>) JSON.parse(messJson);
        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        Integer custId = (Integer) session.getAttribute("custId");
        if (custId != null) {
            Image image = null;
            if (map.get("imagePath") != null && map.get("imagePath") != "") {
                image = new Image();
                image.setCustId(custId);
                image.setCategoryId(15);
                image.setImageName("社区图片");
                image.setComprePath((String) map.get("imagePath"));
                image.setNocomprePath((String) map.get("imagePath"));
            }

            CommunityMessage communityMessage = new CommunityMessage();
            communityMessage.setCustId(custId);
            communityMessage.setCommunityId((Integer) map.get("communityId"));
            communityMessage.setMessageContent((String) map.get("messContent"));

            if (communityMessageService.addCommunityMessage(image, communityMessage) > 0) {
                messMap.put("status", 1);
            }
        }
        return messMap;
    }

    /**
     * 删除信息
     *
     * @param messJson 被删除信息
     * @return 状态码
     */
    @DeleteMapping("del/mess")
    public Map<String, Object> delMessage(@RequestBody String messJson) {

        Map<String, Object> map = (Map<String, Object>) JSON.parse(messJson);
        Map<String, Object> messMap = new HashMap<>();
        messMap.put("status", 0);

        if (map.get("messId") != null) {
            if (communityMessageService.deleteCommunityMessage
                    (Integer.parseInt((String) map.get("messId"))) > 0) {
                messMap.put("status", 1);
            }
        }
        return messMap;
    }

    /*******************************************社区搜索部分*********************************************/

    /**
     * 导航栏动相关内容展示
     *
     * @param context 关键字
     * @return 封装好的数据集合
     */
    @GetMapping("get/navContext/{context}")
    public Map<String, Object> getNavSearchContext(@PathVariable String context) {

        Map<String, Object> searchMap = communityService.selectAnythingByContext(context);
        return searchMap;
    }

    /**
     * 导航栏搜索内容
     *
     * @param session session获得需要查询的关键字
     * @return 封装好的数据集合
     */
    @GetMapping("get/context")
    public Map<String, Object> getSearchContext(HttpSession session) {


        //获取session中的关键字
        String context = (String) session.getAttribute("context");
        //获去session中的类别id
        String categoryId = (String) session.getAttribute("categoryId");
        //用完就删
        session.removeAttribute("context");
        session.removeAttribute("categoryId");


        //新建搜索返回容器
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("status", 0);
        //设置初始状态
        searchMap.put("flag", 0);

        if ((context == null || context.equals("")) && categoryId == null) {
            searchMap.put("status", 1);
            //如果没有内置session值则返回推荐内容
            //取得推荐社区容器
            Map<String, Object> commMap = communityService.selectCommunityByNew();
            searchMap.put("communityList", commMap.get("communityList"));
            //取得推荐信息容器
            Map<String, Object> messMap = communityMessageService.selectNCommunityMessage(6);
            searchMap.put("messageList", messMap.get("messageList"));
        } else if (categoryId == null) {
            //如果类别id为空则表示输入的为内容 也表示关键字不为空
            searchMap.put("context", context);
            //设置初始值怕查不到任何内容
            searchMap.put("flag", 1);
            //根据关键字查询社区
            List<Map<String, Object>> commMap = communityService.selectCommunityByContext(context);
            //根据关键字查询信息
            List<Map<String, Object>> messMap = communityMessageService.selectMessageByContext(context);
            if (commMap != null) {
                searchMap.put("status", 1);
                searchMap.put("communityList", commMap);
                searchMap.put("flag", 2);
            }
            if (messMap != null) {
                searchMap.put("status", 1);
                searchMap.put("messageList", messMap);
                searchMap.put("flag", 2);
            }
        } else {
            //设置初始值怕查不到任何内容
            searchMap.put("flag", 1);
            //强转类型
            Integer cateId = Integer.parseInt(categoryId);
            //根据类别id查询社区
            List<Map<String, Object>> commMap = communityService.selectCommunityByCategoryId(cateId);
            if (commMap != null) {
                searchMap.put("status", 1);
                searchMap.put("communityList", commMap);
                searchMap.put("flag", 2);
            }
        }
        return searchMap;
    }

    /**
     * 社区内容搜索
     *
     * @param context 关键字
     * @return 封装好的数据集合
     */
    @GetMapping("get/context/{context}")
    public Map<String, Object> getSearch(@PathVariable String context) {
        //新建搜索返回容器
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("status", 0);
        //设置初始状态
        searchMap.put("flag", 1);
        //如果类别id为空则表示输入的为内容 也表示关键字不为空
        searchMap.put("context", context);
        //根据关键字查询社区
        List<Map<String, Object>> commMap = communityService.selectCommunityByContext(context);
        //根据关键字查询信息
        List<Map<String, Object>> messMap = communityMessageService.selectMessageByContext(context);
        if (commMap != null) {
            searchMap.put("status", 1);
            searchMap.put("communityList", commMap);
            searchMap.put("flag", 2);
        }
        if (messMap != null) {
            searchMap.put("status", 1);
            searchMap.put("messageList", messMap);
            searchMap.put("flag", 2);
        }
        return searchMap;
    }
}
