package me.microcool.retrofit2demo.bean;

/**
 * Created by Administrator on 2017/8/28.
 */

public class ApiInfo {

    private ApiInfoBean apiInfo;

    public ApiInfoBean getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfoBean apiInfo) {
        this.apiInfo = apiInfo;
    }

    class ApiInfoBean {
        private String apiName;
        private String apiKey;

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }


}
