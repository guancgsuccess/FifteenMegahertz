package com.fm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemTopicIsNull() {
            addCriterion("item_topic is null");
            return (Criteria) this;
        }

        public Criteria andItemTopicIsNotNull() {
            addCriterion("item_topic is not null");
            return (Criteria) this;
        }

        public Criteria andItemTopicEqualTo(String value) {
            addCriterion("item_topic =", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicNotEqualTo(String value) {
            addCriterion("item_topic <>", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicGreaterThan(String value) {
            addCriterion("item_topic >", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicGreaterThanOrEqualTo(String value) {
            addCriterion("item_topic >=", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicLessThan(String value) {
            addCriterion("item_topic <", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicLessThanOrEqualTo(String value) {
            addCriterion("item_topic <=", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicLike(String value) {
            addCriterion("item_topic like", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicNotLike(String value) {
            addCriterion("item_topic not like", value, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicIn(List<String> values) {
            addCriterion("item_topic in", values, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicNotIn(List<String> values) {
            addCriterion("item_topic not in", values, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicBetween(String value1, String value2) {
            addCriterion("item_topic between", value1, value2, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemTopicNotBetween(String value1, String value2) {
            addCriterion("item_topic not between", value1, value2, "itemTopic");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIsNull() {
            addCriterion("item_create_time is null");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIsNotNull() {
            addCriterion("item_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeEqualTo(Date value) {
            addCriterion("item_create_time =", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotEqualTo(Date value) {
            addCriterion("item_create_time <>", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeGreaterThan(Date value) {
            addCriterion("item_create_time >", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("item_create_time >=", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeLessThan(Date value) {
            addCriterion("item_create_time <", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("item_create_time <=", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIn(List<Date> values) {
            addCriterion("item_create_time in", values, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotIn(List<Date> values) {
            addCriterion("item_create_time not in", values, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeBetween(Date value1, Date value2) {
            addCriterion("item_create_time between", value1, value2, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("item_create_time not between", value1, value2, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeIsNull() {
            addCriterion("item_end_time is null");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeIsNotNull() {
            addCriterion("item_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeEqualTo(Date value) {
            addCriterion("item_end_time =", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeNotEqualTo(Date value) {
            addCriterion("item_end_time <>", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeGreaterThan(Date value) {
            addCriterion("item_end_time >", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("item_end_time >=", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeLessThan(Date value) {
            addCriterion("item_end_time <", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("item_end_time <=", value, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeIn(List<Date> values) {
            addCriterion("item_end_time in", values, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeNotIn(List<Date> values) {
            addCriterion("item_end_time not in", values, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeBetween(Date value1, Date value2) {
            addCriterion("item_end_time between", value1, value2, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("item_end_time not between", value1, value2, "itemEndTime");
            return (Criteria) this;
        }

        public Criteria andItemInfoIsNull() {
            addCriterion("item_info is null");
            return (Criteria) this;
        }

        public Criteria andItemInfoIsNotNull() {
            addCriterion("item_info is not null");
            return (Criteria) this;
        }

        public Criteria andItemInfoEqualTo(String value) {
            addCriterion("item_info =", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoNotEqualTo(String value) {
            addCriterion("item_info <>", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoGreaterThan(String value) {
            addCriterion("item_info >", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoGreaterThanOrEqualTo(String value) {
            addCriterion("item_info >=", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoLessThan(String value) {
            addCriterion("item_info <", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoLessThanOrEqualTo(String value) {
            addCriterion("item_info <=", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoLike(String value) {
            addCriterion("item_info like", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoNotLike(String value) {
            addCriterion("item_info not like", value, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoIn(List<String> values) {
            addCriterion("item_info in", values, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoNotIn(List<String> values) {
            addCriterion("item_info not in", values, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoBetween(String value1, String value2) {
            addCriterion("item_info between", value1, value2, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemInfoNotBetween(String value1, String value2) {
            addCriterion("item_info not between", value1, value2, "itemInfo");
            return (Criteria) this;
        }

        public Criteria andItemRulerIsNull() {
            addCriterion("item_ruler is null");
            return (Criteria) this;
        }

        public Criteria andItemRulerIsNotNull() {
            addCriterion("item_ruler is not null");
            return (Criteria) this;
        }

        public Criteria andItemRulerEqualTo(String value) {
            addCriterion("item_ruler =", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerNotEqualTo(String value) {
            addCriterion("item_ruler <>", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerGreaterThan(String value) {
            addCriterion("item_ruler >", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerGreaterThanOrEqualTo(String value) {
            addCriterion("item_ruler >=", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerLessThan(String value) {
            addCriterion("item_ruler <", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerLessThanOrEqualTo(String value) {
            addCriterion("item_ruler <=", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerLike(String value) {
            addCriterion("item_ruler like", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerNotLike(String value) {
            addCriterion("item_ruler not like", value, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerIn(List<String> values) {
            addCriterion("item_ruler in", values, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerNotIn(List<String> values) {
            addCriterion("item_ruler not in", values, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerBetween(String value1, String value2) {
            addCriterion("item_ruler between", value1, value2, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemRulerNotBetween(String value1, String value2) {
            addCriterion("item_ruler not between", value1, value2, "itemRuler");
            return (Criteria) this;
        }

        public Criteria andItemPrizeIsNull() {
            addCriterion("item_prize is null");
            return (Criteria) this;
        }

        public Criteria andItemPrizeIsNotNull() {
            addCriterion("item_prize is not null");
            return (Criteria) this;
        }

        public Criteria andItemPrizeEqualTo(String value) {
            addCriterion("item_prize =", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeNotEqualTo(String value) {
            addCriterion("item_prize <>", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeGreaterThan(String value) {
            addCriterion("item_prize >", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeGreaterThanOrEqualTo(String value) {
            addCriterion("item_prize >=", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeLessThan(String value) {
            addCriterion("item_prize <", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeLessThanOrEqualTo(String value) {
            addCriterion("item_prize <=", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeLike(String value) {
            addCriterion("item_prize like", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeNotLike(String value) {
            addCriterion("item_prize not like", value, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeIn(List<String> values) {
            addCriterion("item_prize in", values, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeNotIn(List<String> values) {
            addCriterion("item_prize not in", values, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeBetween(String value1, String value2) {
            addCriterion("item_prize between", value1, value2, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemPrizeNotBetween(String value1, String value2) {
            addCriterion("item_prize not between", value1, value2, "itemPrize");
            return (Criteria) this;
        }

        public Criteria andItemImgPathIsNull() {
            addCriterion("item_img_path is null");
            return (Criteria) this;
        }

        public Criteria andItemImgPathIsNotNull() {
            addCriterion("item_img_path is not null");
            return (Criteria) this;
        }

        public Criteria andItemImgPathEqualTo(String value) {
            addCriterion("item_img_path =", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathNotEqualTo(String value) {
            addCriterion("item_img_path <>", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathGreaterThan(String value) {
            addCriterion("item_img_path >", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("item_img_path >=", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathLessThan(String value) {
            addCriterion("item_img_path <", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathLessThanOrEqualTo(String value) {
            addCriterion("item_img_path <=", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathLike(String value) {
            addCriterion("item_img_path like", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathNotLike(String value) {
            addCriterion("item_img_path not like", value, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathIn(List<String> values) {
            addCriterion("item_img_path in", values, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathNotIn(List<String> values) {
            addCriterion("item_img_path not in", values, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathBetween(String value1, String value2) {
            addCriterion("item_img_path between", value1, value2, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemImgPathNotBetween(String value1, String value2) {
            addCriterion("item_img_path not between", value1, value2, "itemImgPath");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNull() {
            addCriterion("item_status is null");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNotNull() {
            addCriterion("item_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatusEqualTo(Integer value) {
            addCriterion("item_status =", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotEqualTo(Integer value) {
            addCriterion("item_status <>", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThan(Integer value) {
            addCriterion("item_status >", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_status >=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThan(Integer value) {
            addCriterion("item_status <", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThanOrEqualTo(Integer value) {
            addCriterion("item_status <=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusIn(List<Integer> values) {
            addCriterion("item_status in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotIn(List<Integer> values) {
            addCriterion("item_status not in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusBetween(Integer value1, Integer value2) {
            addCriterion("item_status between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("item_status not between", value1, value2, "itemStatus");
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