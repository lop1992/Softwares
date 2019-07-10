package vip.lop1992.markdowngenerate;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author lop199
 * markdown
 */
@Entity
@DynamicUpdate(true)
@Table(name = "mark_down")
public class MarkDown {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(length = 64)
    private Long pid;


    @Column(length = 64)
    private String name;
    /**
     * 内容
     */
    @Column(length = 99999)
    private String content;

    /**
     *  mdHtml
     */
    @Column(length = 99999)
    private String contentHtml;

    /**
     * 创建日期
     */
    @Column
    private Date createTime;
    /**
     * 创建人
     */
    @Column(length = 128)
    private String createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
