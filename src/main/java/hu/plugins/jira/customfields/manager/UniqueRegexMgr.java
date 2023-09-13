package hu.plugins.jira.customfields.manager;

import hu.plugins.jira.customfields.model.CFData;

public interface UniqueRegexMgr {

    CFData getCFData(String cfKey);

    void setCfJql(String cfKey, String jql);
    void setCfRegex(String cfKey, String regex);
    void setCfRegexError(String cfKey, String regexError);
    void setCfTarget(String cfKey, String target);
    void setUniqueError(String cfKey, String uniqueError);
}
