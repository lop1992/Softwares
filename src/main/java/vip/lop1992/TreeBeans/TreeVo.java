package vip.lop1992.TreeBeans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * @Author: lop1992
 * @Date: 2019/4/19 17:10
 * 毕竟写代码才不花钱啊
 **/
public class TreeVo implements java.io.Serializable{
    private String text;
    private List<TreeVo> children;
    private String icon = "fa fa-map-o";
    private String value;
    private Boolean opened;
    private Boolean disabled;
    private Boolean selected;
    private Boolean dragDisabled;
    private Boolean dropDisabled;
    private Object data;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeVo> getChildren() {
        return children;
    }

   // @JsonManagedReference
    public void setChildren(List<TreeVo> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getDragDisabled() {
        return dragDisabled;
    }

    public void setDragDisabled(Boolean dragDisabled) {
        this.dragDisabled = dragDisabled;
    }

    public Boolean getDropDisabled() {
        return dropDisabled;
    }

    public void setDropDisabled(Boolean dropDisabled) {
        this.dropDisabled = dropDisabled;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
