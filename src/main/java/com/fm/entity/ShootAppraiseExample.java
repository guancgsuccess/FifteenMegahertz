package com.fm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShootAppraiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShootAppraiseExample() {
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

        public Criteria andAppraiseIdIsNull() {
            addCriterion("appraise_id is null");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdIsNotNull() {
            addCriterion("appraise_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdEqualTo(Integer value) {
            addCriterion("appraise_id =", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdNotEqualTo(Integer value) {
            addCriterion("appraise_id <>", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdGreaterThan(Integer value) {
            addCriterion("appraise_id >", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraise_id >=", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdLessThan(Integer value) {
            addCriterion("appraise_id <", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdLessThanOrEqualTo(Integer value) {
            addCriterion("appraise_id <=", value, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdIn(List<Integer> values) {
            addCriterion("appraise_id in", values, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdNotIn(List<Integer> values) {
            addCriterion("appraise_id not in", values, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdBetween(Integer value1, Integer value2) {
            addCriterion("appraise_id between", value1, value2, "appraiseId");
            return (Criteria) this;
        }

        public Criteria andAppraiseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appraise_id not between", value1, value2, "appraiseId");
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

        public Criteria andCustAnswerIdIsNull() {
            addCriterion("cust_answer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdIsNotNull() {
            addCriterion("cust_answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdEqualTo(Integer value) {
            addCriterion("cust_answer_id =", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdNotEqualTo(Integer value) {
            addCriterion("cust_answer_id <>", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdGreaterThan(Integer value) {
            addCriterion("cust_answer_id >", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_answer_id >=", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdLessThan(Integer value) {
            addCriterion("cust_answer_id <", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_answer_id <=", value, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdIn(List<Integer> values) {
            addCriterion("cust_answer_id in", values, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdNotIn(List<Integer> values) {
            addCriterion("cust_answer_id not in", values, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_answer_id between", value1, value2, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andCustAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_answer_id not between", value1, value2, "custAnswerId");
            return (Criteria) this;
        }

        public Criteria andShootIdIsNull() {
            addCriterion("shoot_id is null");
            return (Criteria) this;
        }

        public Criteria andShootIdIsNotNull() {
            addCriterion("shoot_id is not null");
            return (Criteria) this;
        }

        public Criteria andShootIdEqualTo(Integer value) {
            addCriterion("shoot_id =", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotEqualTo(Integer value) {
            addCriterion("shoot_id <>", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdGreaterThan(Integer value) {
            addCriterion("shoot_id >", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_id >=", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdLessThan(Integer value) {
            addCriterion("shoot_id <", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_id <=", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdIn(List<Integer> values) {
            addCriterion("shoot_id in", values, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotIn(List<Integer> values) {
            addCriterion("shoot_id not in", values, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdBetween(Integer value1, Integer value2) {
            addCriterion("shoot_id between", value1, value2, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_id not between", value1, value2, "shootId");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeIsNull() {
            addCriterion("appraise_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeIsNotNull() {
            addCriterion("appraise_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeEqualTo(Date value) {
            addCriterion("appraise_create_time =", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeNotEqualTo(Date value) {
            addCriterion("appraise_create_time <>", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeGreaterThan(Date value) {
            addCriterion("appraise_create_time >", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appraise_create_time >=", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeLessThan(Date value) {
            addCriterion("appraise_create_time <", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("appraise_create_time <=", value, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeIn(List<Date> values) {
            addCriterion("appraise_create_time in", values, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeNotIn(List<Date> values) {
            addCriterion("appraise_create_time not in", values, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeBetween(Date value1, Date value2) {
            addCriterion("appraise_create_time between", value1, value2, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("appraise_create_time not between", value1, value2, "appraiseCreateTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeIsNull() {
            addCriterion("appraise_range is null");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeIsNotNull() {
            addCriterion("appraise_range is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeEqualTo(Integer value) {
            addCriterion("appraise_range =", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeNotEqualTo(Integer value) {
            addCriterion("appraise_range <>", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeGreaterThan(Integer value) {
            addCriterion("appraise_range >", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraise_range >=", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeLessThan(Integer value) {
            addCriterion("appraise_range <", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeLessThanOrEqualTo(Integer value) {
            addCriterion("appraise_range <=", value, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeIn(List<Integer> values) {
            addCriterion("appraise_range in", values, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeNotIn(List<Integer> values) {
            addCriterion("appraise_range not in", values, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeBetween(Integer value1, Integer value2) {
            addCriterion("appraise_range between", value1, value2, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("appraise_range not between", value1, value2, "appraiseRange");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusIsNull() {
            addCriterion("appraise_status is null");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusIsNotNull() {
            addCriterion("appraise_status is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusEqualTo(Integer value) {
            addCriterion("appraise_status =", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusNotEqualTo(Integer value) {
            addCriterion("appraise_status <>", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusGreaterThan(Integer value) {
            addCriterion("appraise_status >", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraise_status >=", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusLessThan(Integer value) {
            addCriterion("appraise_status <", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("appraise_status <=", value, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusIn(List<Integer> values) {
            addCriterion("appraise_status in", values, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusNotIn(List<Integer> values) {
            addCriterion("appraise_status not in", values, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusBetween(Integer value1, Integer value2) {
            addCriterion("appraise_status between", value1, value2, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andAppraiseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("appraise_status not between", value1, value2, "appraiseStatus");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNull() {
            addCriterion("blank_1 is null");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNotNull() {
            addCriterion("blank_1 is not null");
            return (Criteria) this;
        }

        public Criteria andBlank1EqualTo(String value) {
            addCriterion("blank_1 =", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotEqualTo(String value) {
            addCriterion("blank_1 <>", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThan(String value) {
            addCriterion("blank_1 >", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThanOrEqualTo(String value) {
            addCriterion("blank_1 >=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThan(String value) {
            addCriterion("blank_1 <", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThanOrEqualTo(String value) {
            addCriterion("blank_1 <=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Like(String value) {
            addCriterion("blank_1 like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotLike(String value) {
            addCriterion("blank_1 not like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1In(List<String> values) {
            addCriterion("blank_1 in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotIn(List<String> values) {
            addCriterion("blank_1 not in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Between(String value1, String value2) {
            addCriterion("blank_1 between", value1, value2, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotBetween(String value1, String value2) {
            addCriterion("blank_1 not between", value1, value2, "blank1");
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