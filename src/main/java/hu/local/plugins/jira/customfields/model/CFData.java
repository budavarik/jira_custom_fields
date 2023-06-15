package hu.local.plugins.jira.customfields.model;

public class CFData {
    private String cfKey;
    private String cfName;

    /**
     * JQL to check field value for uniqueness.
     */
    private String jql;

    /**
     * Custom error if field value is not not unique.
     */
    private String uniqueError;

    /**
     * Regex for custom field value.
     */
    private String regex;

    /**
     * Custom error if field value is not satisfied Regex.
     */
    private String regexError;

    private String targetCf;
    private String targetCfName;

    public CFData(String regex, String regexError, String jql, String uniqueError, String targetCf) {
        this.regex = regex;
        this.regexError = regexError;
        this.jql = jql;
        this.uniqueError = uniqueError;
        this.targetCf = targetCf;
    }

    public String getCfKey() {
        return cfKey;
    }

    public String getCfName() {
        return cfName;
    }

    public String getJql() {
        return jql;
    }

    public String getRegex() {
        return regex;
    }

    public String getRegexError() {
        return regexError;
    }

    public String getTargetCf() {
        if (targetCf != null && targetCf.length() > 0) {
            int index = targetCf.indexOf(":");
            if (index > 0) {
                return targetCf.substring(0, index);
            } else {
                return targetCf;
            }
        }
        return "";
    }

    public String getUniqueError() {
        return uniqueError;
    }

    public void setUniqueError(String uniqueError) {
        this.uniqueError = uniqueError;
    }

    public String getTargetCfName() {
        return targetCfName;
    }

    public void setCfKey(String cfKey) {
        this.cfKey = cfKey;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public void setTargetCfName(String targetCfName) {
        this.targetCfName = targetCfName;
    }

    @Override
    public String toString() {
        return "CFData{" +
                "cfKey='" + cfKey + '\'' +
                ", cfName='" + cfName + '\'' +
                ", jql='" + jql + '\'' +
                ", uniqueError='" + uniqueError + '\'' +
                ", regex='" + regex + '\'' +
                ", regexError='" + regexError + '\'' +
                ", targetCf='" + targetCf + '\'' +
                ", targetCfName='" + targetCfName + '\'' +
                '}';
    }
}
