package com.fm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ImageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Integer value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Integer value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Integer value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Integer value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Integer> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Integer> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Integer value1, Integer value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andImageKeywordIsNull() {
            addCriterion("image_keyword is null");
            return (Criteria) this;
        }

        public Criteria andImageKeywordIsNotNull() {
            addCriterion("image_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andImageKeywordEqualTo(String value) {
            addCriterion("image_keyword =", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordNotEqualTo(String value) {
            addCriterion("image_keyword <>", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordGreaterThan(String value) {
            addCriterion("image_keyword >", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("image_keyword >=", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordLessThan(String value) {
            addCriterion("image_keyword <", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordLessThanOrEqualTo(String value) {
            addCriterion("image_keyword <=", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordLike(String value) {
            addCriterion("image_keyword like", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordNotLike(String value) {
            addCriterion("image_keyword not like", value, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordIn(List<String> values) {
            addCriterion("image_keyword in", values, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordNotIn(List<String> values) {
            addCriterion("image_keyword not in", values, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordBetween(String value1, String value2) {
            addCriterion("image_keyword between", value1, value2, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andImageKeywordNotBetween(String value1, String value2) {
            addCriterion("image_keyword not between", value1, value2, "imageKeyword");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNull() {
            addCriterion("image_name is null");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNotNull() {
            addCriterion("image_name is not null");
            return (Criteria) this;
        }

        public Criteria andImageNameEqualTo(String value) {
            addCriterion("image_name =", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotEqualTo(String value) {
            addCriterion("image_name <>", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThan(String value) {
            addCriterion("image_name >", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThanOrEqualTo(String value) {
            addCriterion("image_name >=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThan(String value) {
            addCriterion("image_name <", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThanOrEqualTo(String value) {
            addCriterion("image_name <=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLike(String value) {
            addCriterion("image_name like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotLike(String value) {
            addCriterion("image_name not like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameIn(List<String> values) {
            addCriterion("image_name in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotIn(List<String> values) {
            addCriterion("image_name not in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameBetween(String value1, String value2) {
            addCriterion("image_name between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotBetween(String value1, String value2) {
            addCriterion("image_name not between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageClicksIsNull() {
            addCriterion("image_clicks is null");
            return (Criteria) this;
        }

        public Criteria andImageClicksIsNotNull() {
            addCriterion("image_clicks is not null");
            return (Criteria) this;
        }

        public Criteria andImageClicksEqualTo(Integer value) {
            addCriterion("image_clicks =", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksNotEqualTo(Integer value) {
            addCriterion("image_clicks <>", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksGreaterThan(Integer value) {
            addCriterion("image_clicks >", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_clicks >=", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksLessThan(Integer value) {
            addCriterion("image_clicks <", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksLessThanOrEqualTo(Integer value) {
            addCriterion("image_clicks <=", value, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksIn(List<Integer> values) {
            addCriterion("image_clicks in", values, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksNotIn(List<Integer> values) {
            addCriterion("image_clicks not in", values, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksBetween(Integer value1, Integer value2) {
            addCriterion("image_clicks between", value1, value2, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("image_clicks not between", value1, value2, "imageClicks");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsIsNull() {
            addCriterion("image_collections is null");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsIsNotNull() {
            addCriterion("image_collections is not null");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsEqualTo(Integer value) {
            addCriterion("image_collections =", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsNotEqualTo(Integer value) {
            addCriterion("image_collections <>", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsGreaterThan(Integer value) {
            addCriterion("image_collections >", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_collections >=", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsLessThan(Integer value) {
            addCriterion("image_collections <", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsLessThanOrEqualTo(Integer value) {
            addCriterion("image_collections <=", value, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsIn(List<Integer> values) {
            addCriterion("image_collections in", values, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsNotIn(List<Integer> values) {
            addCriterion("image_collections not in", values, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsBetween(Integer value1, Integer value2) {
            addCriterion("image_collections between", value1, value2, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageCollectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("image_collections not between", value1, value2, "imageCollections");
            return (Criteria) this;
        }

        public Criteria andImageLikesIsNull() {
            addCriterion("image_likes is null");
            return (Criteria) this;
        }

        public Criteria andImageLikesIsNotNull() {
            addCriterion("image_likes is not null");
            return (Criteria) this;
        }

        public Criteria andImageLikesEqualTo(Integer value) {
            addCriterion("image_likes =", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesNotEqualTo(Integer value) {
            addCriterion("image_likes <>", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesGreaterThan(Integer value) {
            addCriterion("image_likes >", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_likes >=", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesLessThan(Integer value) {
            addCriterion("image_likes <", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesLessThanOrEqualTo(Integer value) {
            addCriterion("image_likes <=", value, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesIn(List<Integer> values) {
            addCriterion("image_likes in", values, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesNotIn(List<Integer> values) {
            addCriterion("image_likes not in", values, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesBetween(Integer value1, Integer value2) {
            addCriterion("image_likes between", value1, value2, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("image_likes not between", value1, value2, "imageLikes");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsIsNull() {
            addCriterion("image_downloads is null");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsIsNotNull() {
            addCriterion("image_downloads is not null");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsEqualTo(Integer value) {
            addCriterion("image_downloads =", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsNotEqualTo(Integer value) {
            addCriterion("image_downloads <>", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsGreaterThan(Integer value) {
            addCriterion("image_downloads >", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_downloads >=", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsLessThan(Integer value) {
            addCriterion("image_downloads <", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsLessThanOrEqualTo(Integer value) {
            addCriterion("image_downloads <=", value, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsIn(List<Integer> values) {
            addCriterion("image_downloads in", values, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsNotIn(List<Integer> values) {
            addCriterion("image_downloads not in", values, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsBetween(Integer value1, Integer value2) {
            addCriterion("image_downloads between", value1, value2, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageDownloadsNotBetween(Integer value1, Integer value2) {
            addCriterion("image_downloads not between", value1, value2, "imageDownloads");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeIsNull() {
            addCriterion("image_is_free is null");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeIsNotNull() {
            addCriterion("image_is_free is not null");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeEqualTo(Integer value) {
            addCriterion("image_is_free =", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeNotEqualTo(Integer value) {
            addCriterion("image_is_free <>", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeGreaterThan(Integer value) {
            addCriterion("image_is_free >", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_is_free >=", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeLessThan(Integer value) {
            addCriterion("image_is_free <", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeLessThanOrEqualTo(Integer value) {
            addCriterion("image_is_free <=", value, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeIn(List<Integer> values) {
            addCriterion("image_is_free in", values, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeNotIn(List<Integer> values) {
            addCriterion("image_is_free not in", values, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeBetween(Integer value1, Integer value2) {
            addCriterion("image_is_free between", value1, value2, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageIsFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("image_is_free not between", value1, value2, "imageIsFree");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNull() {
            addCriterion("image_status is null");
            return (Criteria) this;
        }

        public Criteria andImageStatusIsNotNull() {
            addCriterion("image_status is not null");
            return (Criteria) this;
        }

        public Criteria andImageStatusEqualTo(Integer value) {
            addCriterion("image_status =", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotEqualTo(Integer value) {
            addCriterion("image_status <>", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThan(Integer value) {
            addCriterion("image_status >", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_status >=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThan(Integer value) {
            addCriterion("image_status <", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("image_status <=", value, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusIn(List<Integer> values) {
            addCriterion("image_status in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotIn(List<Integer> values) {
            addCriterion("image_status not in", values, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusBetween(Integer value1, Integer value2) {
            addCriterion("image_status between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andImageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("image_status not between", value1, value2, "imageStatus");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthIsNull() {
            addCriterion("camera_focal_lenth is null");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthIsNotNull() {
            addCriterion("camera_focal_lenth is not null");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthEqualTo(String value) {
            addCriterion("camera_focal_lenth =", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthNotEqualTo(String value) {
            addCriterion("camera_focal_lenth <>", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthGreaterThan(String value) {
            addCriterion("camera_focal_lenth >", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthGreaterThanOrEqualTo(String value) {
            addCriterion("camera_focal_lenth >=", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthLessThan(String value) {
            addCriterion("camera_focal_lenth <", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthLessThanOrEqualTo(String value) {
            addCriterion("camera_focal_lenth <=", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthLike(String value) {
            addCriterion("camera_focal_lenth like", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthNotLike(String value) {
            addCriterion("camera_focal_lenth not like", value, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthIn(List<String> values) {
            addCriterion("camera_focal_lenth in", values, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthNotIn(List<String> values) {
            addCriterion("camera_focal_lenth not in", values, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthBetween(String value1, String value2) {
            addCriterion("camera_focal_lenth between", value1, value2, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraFocalLenthNotBetween(String value1, String value2) {
            addCriterion("camera_focal_lenth not between", value1, value2, "cameraFocalLenth");
            return (Criteria) this;
        }

        public Criteria andCameraApertureIsNull() {
            addCriterion("camera_aperture is null");
            return (Criteria) this;
        }

        public Criteria andCameraApertureIsNotNull() {
            addCriterion("camera_aperture is not null");
            return (Criteria) this;
        }

        public Criteria andCameraApertureEqualTo(String value) {
            addCriterion("camera_aperture =", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureNotEqualTo(String value) {
            addCriterion("camera_aperture <>", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureGreaterThan(String value) {
            addCriterion("camera_aperture >", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureGreaterThanOrEqualTo(String value) {
            addCriterion("camera_aperture >=", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureLessThan(String value) {
            addCriterion("camera_aperture <", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureLessThanOrEqualTo(String value) {
            addCriterion("camera_aperture <=", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureLike(String value) {
            addCriterion("camera_aperture like", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureNotLike(String value) {
            addCriterion("camera_aperture not like", value, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureIn(List<String> values) {
            addCriterion("camera_aperture in", values, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureNotIn(List<String> values) {
            addCriterion("camera_aperture not in", values, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureBetween(String value1, String value2) {
            addCriterion("camera_aperture between", value1, value2, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraApertureNotBetween(String value1, String value2) {
            addCriterion("camera_aperture not between", value1, value2, "cameraAperture");
            return (Criteria) this;
        }

        public Criteria andCameraIsoIsNull() {
            addCriterion("camera_iso is null");
            return (Criteria) this;
        }

        public Criteria andCameraIsoIsNotNull() {
            addCriterion("camera_iso is not null");
            return (Criteria) this;
        }

        public Criteria andCameraIsoEqualTo(String value) {
            addCriterion("camera_iso =", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoNotEqualTo(String value) {
            addCriterion("camera_iso <>", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoGreaterThan(String value) {
            addCriterion("camera_iso >", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoGreaterThanOrEqualTo(String value) {
            addCriterion("camera_iso >=", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoLessThan(String value) {
            addCriterion("camera_iso <", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoLessThanOrEqualTo(String value) {
            addCriterion("camera_iso <=", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoLike(String value) {
            addCriterion("camera_iso like", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoNotLike(String value) {
            addCriterion("camera_iso not like", value, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoIn(List<String> values) {
            addCriterion("camera_iso in", values, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoNotIn(List<String> values) {
            addCriterion("camera_iso not in", values, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoBetween(String value1, String value2) {
            addCriterion("camera_iso between", value1, value2, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraIsoNotBetween(String value1, String value2) {
            addCriterion("camera_iso not between", value1, value2, "cameraIso");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeIsNull() {
            addCriterion("camera_exposure_time is null");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeIsNotNull() {
            addCriterion("camera_exposure_time is not null");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeEqualTo(String value) {
            addCriterion("camera_exposure_time =", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeNotEqualTo(String value) {
            addCriterion("camera_exposure_time <>", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeGreaterThan(String value) {
            addCriterion("camera_exposure_time >", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeGreaterThanOrEqualTo(String value) {
            addCriterion("camera_exposure_time >=", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeLessThan(String value) {
            addCriterion("camera_exposure_time <", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeLessThanOrEqualTo(String value) {
            addCriterion("camera_exposure_time <=", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeLike(String value) {
            addCriterion("camera_exposure_time like", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeNotLike(String value) {
            addCriterion("camera_exposure_time not like", value, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeIn(List<String> values) {
            addCriterion("camera_exposure_time in", values, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeNotIn(List<String> values) {
            addCriterion("camera_exposure_time not in", values, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeBetween(String value1, String value2) {
            addCriterion("camera_exposure_time between", value1, value2, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andCameraExposureTimeNotBetween(String value1, String value2) {
            addCriterion("camera_exposure_time not between", value1, value2, "cameraExposureTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIsNull() {
            addCriterion("image_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIsNotNull() {
            addCriterion("image_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeEqualTo(Date value) {
            addCriterion("image_upload_time =", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotEqualTo(Date value) {
            addCriterion("image_upload_time <>", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeGreaterThan(Date value) {
            addCriterion("image_upload_time >", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("image_upload_time >=", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeLessThan(Date value) {
            addCriterion("image_upload_time <", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("image_upload_time <=", value, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeIn(List<Date> values) {
            addCriterion("image_upload_time in", values, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotIn(List<Date> values) {
            addCriterion("image_upload_time not in", values, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeBetween(Date value1, Date value2) {
            addCriterion("image_upload_time between", value1, value2, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImageUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("image_upload_time not between", value1, value2, "imageUploadTime");
            return (Criteria) this;
        }

        public Criteria andImagePriceIsNull() {
            addCriterion("image_price is null");
            return (Criteria) this;
        }

        public Criteria andImagePriceIsNotNull() {
            addCriterion("image_price is not null");
            return (Criteria) this;
        }

        public Criteria andImagePriceEqualTo(Integer value) {
            addCriterion("image_price =", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceNotEqualTo(Integer value) {
            addCriterion("image_price <>", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceGreaterThan(Integer value) {
            addCriterion("image_price >", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_price >=", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceLessThan(Integer value) {
            addCriterion("image_price <", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceLessThanOrEqualTo(Integer value) {
            addCriterion("image_price <=", value, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceIn(List<Integer> values) {
            addCriterion("image_price in", values, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceNotIn(List<Integer> values) {
            addCriterion("image_price not in", values, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceBetween(Integer value1, Integer value2) {
            addCriterion("image_price between", value1, value2, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andImagePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("image_price not between", value1, value2, "imagePrice");
            return (Criteria) this;
        }

        public Criteria andComprePathIsNull() {
            addCriterion("compre_path is null");
            return (Criteria) this;
        }

        public Criteria andComprePathIsNotNull() {
            addCriterion("compre_path is not null");
            return (Criteria) this;
        }

        public Criteria andComprePathEqualTo(String value) {
            addCriterion("compre_path =", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathNotEqualTo(String value) {
            addCriterion("compre_path <>", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathGreaterThan(String value) {
            addCriterion("compre_path >", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathGreaterThanOrEqualTo(String value) {
            addCriterion("compre_path >=", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathLessThan(String value) {
            addCriterion("compre_path <", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathLessThanOrEqualTo(String value) {
            addCriterion("compre_path <=", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathLike(String value) {
            addCriterion("compre_path like", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathNotLike(String value) {
            addCriterion("compre_path not like", value, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathIn(List<String> values) {
            addCriterion("compre_path in", values, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathNotIn(List<String> values) {
            addCriterion("compre_path not in", values, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathBetween(String value1, String value2) {
            addCriterion("compre_path between", value1, value2, "comprePath");
            return (Criteria) this;
        }

        public Criteria andComprePathNotBetween(String value1, String value2) {
            addCriterion("compre_path not between", value1, value2, "comprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathIsNull() {
            addCriterion("nocompre_path is null");
            return (Criteria) this;
        }

        public Criteria andNocomprePathIsNotNull() {
            addCriterion("nocompre_path is not null");
            return (Criteria) this;
        }

        public Criteria andNocomprePathEqualTo(String value) {
            addCriterion("nocompre_path =", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathNotEqualTo(String value) {
            addCriterion("nocompre_path <>", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathGreaterThan(String value) {
            addCriterion("nocompre_path >", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathGreaterThanOrEqualTo(String value) {
            addCriterion("nocompre_path >=", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathLessThan(String value) {
            addCriterion("nocompre_path <", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathLessThanOrEqualTo(String value) {
            addCriterion("nocompre_path <=", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathLike(String value) {
            addCriterion("nocompre_path like", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathNotLike(String value) {
            addCriterion("nocompre_path not like", value, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathIn(List<String> values) {
            addCriterion("nocompre_path in", values, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathNotIn(List<String> values) {
            addCriterion("nocompre_path not in", values, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathBetween(String value1, String value2) {
            addCriterion("nocompre_path between", value1, value2, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andNocomprePathNotBetween(String value1, String value2) {
            addCriterion("nocompre_path not between", value1, value2, "nocomprePath");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessIsNull() {
            addCriterion("image_brightness is null");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessIsNotNull() {
            addCriterion("image_brightness is not null");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessEqualTo(String value) {
            addCriterion("image_brightness =", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessNotEqualTo(String value) {
            addCriterion("image_brightness <>", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessGreaterThan(String value) {
            addCriterion("image_brightness >", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessGreaterThanOrEqualTo(String value) {
            addCriterion("image_brightness >=", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessLessThan(String value) {
            addCriterion("image_brightness <", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessLessThanOrEqualTo(String value) {
            addCriterion("image_brightness <=", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessLike(String value) {
            addCriterion("image_brightness like", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessNotLike(String value) {
            addCriterion("image_brightness not like", value, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessIn(List<String> values) {
            addCriterion("image_brightness in", values, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessNotIn(List<String> values) {
            addCriterion("image_brightness not in", values, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessBetween(String value1, String value2) {
            addCriterion("image_brightness between", value1, value2, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andImageBrightnessNotBetween(String value1, String value2) {
            addCriterion("image_brightness not between", value1, value2, "imageBrightness");
            return (Criteria) this;
        }

        public Criteria andBlank2IsNull() {
            addCriterion("blank_2 is null");
            return (Criteria) this;
        }

        public Criteria andBlank2IsNotNull() {
            addCriterion("blank_2 is not null");
            return (Criteria) this;
        }

        public Criteria andBlank2EqualTo(String value) {
            addCriterion("blank_2 =", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotEqualTo(String value) {
            addCriterion("blank_2 <>", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2GreaterThan(String value) {
            addCriterion("blank_2 >", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2GreaterThanOrEqualTo(String value) {
            addCriterion("blank_2 >=", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2LessThan(String value) {
            addCriterion("blank_2 <", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2LessThanOrEqualTo(String value) {
            addCriterion("blank_2 <=", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2Like(String value) {
            addCriterion("blank_2 like", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotLike(String value) {
            addCriterion("blank_2 not like", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2In(List<String> values) {
            addCriterion("blank_2 in", values, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotIn(List<String> values) {
            addCriterion("blank_2 not in", values, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2Between(String value1, String value2) {
            addCriterion("blank_2 between", value1, value2, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotBetween(String value1, String value2) {
            addCriterion("blank_2 not between", value1, value2, "blank2");
            return (Criteria) this;
        }

        public Criteria andCameraBrandIsNull() {
            addCriterion("camera_brand is null");
            return (Criteria) this;
        }

        public Criteria andCameraBrandIsNotNull() {
            addCriterion("camera_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCameraBrandEqualTo(String value) {
            addCriterion("camera_brand =", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandNotEqualTo(String value) {
            addCriterion("camera_brand <>", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandGreaterThan(String value) {
            addCriterion("camera_brand >", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandGreaterThanOrEqualTo(String value) {
            addCriterion("camera_brand >=", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandLessThan(String value) {
            addCriterion("camera_brand <", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandLessThanOrEqualTo(String value) {
            addCriterion("camera_brand <=", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandLike(String value) {
            addCriterion("camera_brand like", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandNotLike(String value) {
            addCriterion("camera_brand not like", value, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandIn(List<String> values) {
            addCriterion("camera_brand in", values, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandNotIn(List<String> values) {
            addCriterion("camera_brand not in", values, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandBetween(String value1, String value2) {
            addCriterion("camera_brand between", value1, value2, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraBrandNotBetween(String value1, String value2) {
            addCriterion("camera_brand not between", value1, value2, "cameraBrand");
            return (Criteria) this;
        }

        public Criteria andCameraModelIsNull() {
            addCriterion("camera_model is null");
            return (Criteria) this;
        }

        public Criteria andCameraModelIsNotNull() {
            addCriterion("camera_model is not null");
            return (Criteria) this;
        }

        public Criteria andCameraModelEqualTo(String value) {
            addCriterion("camera_model =", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelNotEqualTo(String value) {
            addCriterion("camera_model <>", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelGreaterThan(String value) {
            addCriterion("camera_model >", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelGreaterThanOrEqualTo(String value) {
            addCriterion("camera_model >=", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelLessThan(String value) {
            addCriterion("camera_model <", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelLessThanOrEqualTo(String value) {
            addCriterion("camera_model <=", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelLike(String value) {
            addCriterion("camera_model like", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelNotLike(String value) {
            addCriterion("camera_model not like", value, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelIn(List<String> values) {
            addCriterion("camera_model in", values, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelNotIn(List<String> values) {
            addCriterion("camera_model not in", values, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelBetween(String value1, String value2) {
            addCriterion("camera_model between", value1, value2, "cameraModel");
            return (Criteria) this;
        }

        public Criteria andCameraModelNotBetween(String value1, String value2) {
            addCriterion("camera_model not between", value1, value2, "cameraModel");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}