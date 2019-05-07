package com.el.mbg.domain;

public class DeptModel {
    /**
     *   - dept.deptno
     */
    private Long deptno;

    /**
     *   - dept.dname
     */
    private String dname;

    /**
     *   - dept.db_source
     */
    private String dbSource;

    /**
     *   - dept.id
     */
    private Integer id;

    /**
     *   - dept.pid
     */
    private Integer pid;

    /**
     *   - dept.cid
     */
    private Integer cid;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", dbSource=").append(dbSource);
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", cid=").append(cid);
        sb.append("]");
        return sb.toString();
    }
}