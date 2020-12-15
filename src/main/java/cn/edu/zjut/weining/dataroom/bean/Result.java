package cn.edu.zjut.weining.dataroom.bean;


/**
 * @author panda421
 * @date 2020-12-15 20:20
 */
public class Result<T> {
    /**
     * 返回信息
     */
    private String massage;

    /**
     * 数据是否正常请求
     */
    private int code;

    /**
     * 具体返回的数据
     */
    private T data;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
