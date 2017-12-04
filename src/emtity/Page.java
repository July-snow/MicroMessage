package emtity;

/**
 * @Author: Silence
 * @Date: Create in 22:16 2017/11/30
 * @Description:
 */
public class Page {
    /**
     * 总条数
     */
    private int totalNumber;
    /**
     * 当前页数
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示几条
     */
    private int pageNumber = 5;
    /**
     * 数据库中的limit参数，从第几条开始取
     */
    private int dbIndex;
    /**
     * 数据库汇总的limit参数，一共取多少条
     */
    private int dbNumber;

    /**
     * 根据当前对象中的属性值计算并设置相关属性
     */

    public void count() {
        //计算总页数
        int totalPageTemp = this.totalNumber / this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if (totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        //设置当前页数
        //当前页数大于总页数，应将当亲页数设置为总页数
        if (this.totalPage < this.currentPage)
            this.totalPage = this.currentPage;

        //当前页数小于1时设置为1
        if (this.currentPage < 1)
            this.currentPage = 1;

        //设置limit参数
        this.dbIndex = (this.currentPage-1)*this.pageNumber;
        this.dbNumber = this.pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        //传入总条数时计算各项参数
        this.count();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}
