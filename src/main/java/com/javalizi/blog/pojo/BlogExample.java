package com.javalizi.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String releaseDateStr;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andReleasedateIsNull() {
            addCriterion("releaseDate is null");
            return (Criteria) this;
        }

        public Criteria andReleasedateIsNotNull() {
            addCriterion("releaseDate is not null");
            return (Criteria) this;
        }

        public Criteria andReleasedateEqualTo(Date value) {
            addCriterion("releaseDate =", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateNotEqualTo(Date value) {
            addCriterion("releaseDate <>", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateGreaterThan(Date value) {
            addCriterion("releaseDate >", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateGreaterThanOrEqualTo(Date value) {
            addCriterion("releaseDate >=", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateLessThan(Date value) {
            addCriterion("releaseDate <", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateLessThanOrEqualTo(Date value) {
            addCriterion("releaseDate <=", value, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateIn(List<Date> values) {
            addCriterion("releaseDate in", values, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateNotIn(List<Date> values) {
            addCriterion("releaseDate not in", values, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateBetween(Date value1, Date value2) {
            addCriterion("releaseDate between", value1, value2, "releasedate");
            return (Criteria) this;
        }

        public Criteria andReleasedateNotBetween(Date value1, Date value2) {
            addCriterion("releaseDate not between", value1, value2, "releasedate");
            return (Criteria) this;
        }

        public Criteria andClickhitIsNull() {
            addCriterion("clickHit is null");
            return (Criteria) this;
        }

        public Criteria andClickhitIsNotNull() {
            addCriterion("clickHit is not null");
            return (Criteria) this;
        }

        public Criteria andClickhitEqualTo(Integer value) {
            addCriterion("clickHit =", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitNotEqualTo(Integer value) {
            addCriterion("clickHit <>", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitGreaterThan(Integer value) {
            addCriterion("clickHit >", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickHit >=", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitLessThan(Integer value) {
            addCriterion("clickHit <", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitLessThanOrEqualTo(Integer value) {
            addCriterion("clickHit <=", value, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitIn(List<Integer> values) {
            addCriterion("clickHit in", values, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitNotIn(List<Integer> values) {
            addCriterion("clickHit not in", values, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitBetween(Integer value1, Integer value2) {
            addCriterion("clickHit between", value1, value2, "clickhit");
            return (Criteria) this;
        }

        public Criteria andClickhitNotBetween(Integer value1, Integer value2) {
            addCriterion("clickHit not between", value1, value2, "clickhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitIsNull() {
            addCriterion("replyHit is null");
            return (Criteria) this;
        }

        public Criteria andReplyhitIsNotNull() {
            addCriterion("replyHit is not null");
            return (Criteria) this;
        }

        public Criteria andReplyhitEqualTo(Integer value) {
            addCriterion("replyHit =", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitNotEqualTo(Integer value) {
            addCriterion("replyHit <>", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitGreaterThan(Integer value) {
            addCriterion("replyHit >", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyHit >=", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitLessThan(Integer value) {
            addCriterion("replyHit <", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitLessThanOrEqualTo(Integer value) {
            addCriterion("replyHit <=", value, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitIn(List<Integer> values) {
            addCriterion("replyHit in", values, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitNotIn(List<Integer> values) {
            addCriterion("replyHit not in", values, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitBetween(Integer value1, Integer value2) {
            addCriterion("replyHit between", value1, value2, "replyhit");
            return (Criteria) this;
        }

        public Criteria andReplyhitNotBetween(Integer value1, Integer value2) {
            addCriterion("replyHit not between", value1, value2, "replyhit");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyWord is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyWord is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyWord =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyWord <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyWord >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyWord >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyWord <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyWord <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyWord like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyWord not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyWord in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyWord not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyWord between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyWord not between", value1, value2, "keyword");
            return (Criteria) this;
        }
    }

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