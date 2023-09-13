package hu.plugins.jira.customfields.action;

import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.security.GlobalPermissionManager;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.security.xsrf.RequiresXsrfCheck;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import hu.plugins.jira.customfields.manager.UniqueRegexMgr;
import hu.plugins.jira.customfields.model.CFData;
import hu.plugins.jira.customfields.utils.UrUtils;

import com.atlassian.jira.security.request.RequestMethod;
import com.atlassian.jira.security.request.SupportedMethods;
import webwork.action.ServletActionContext;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.atlassian.jira.permission.GlobalPermissionKey.ADMINISTER;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trim;

@SupportedMethods({RequestMethod.GET, RequestMethod.POST})
public class RichterRegexFieldConfig extends JiraWebActionSupport {
    //private static final long serialVersionUID = -727825112402972172L;
    private static final long serialVersionUID = -7278512402972172L;

    private final UniqueRegexMgr urMgr;
    private final CustomFieldManager cfMgr;
    private final GlobalPermissionManager globalPermissionManager;
    private final JiraAuthenticationContext authenticationContext;

    private String customFieldId;
    private String regexclause;
    private String regexerror;
    private String jqlError;
    private String jqlclause;
    private String targetcf;

    public RichterRegexFieldConfig(
            UniqueRegexMgr urMgr,
            CustomFieldManager cfMgr,
            GlobalPermissionManager globalPermissionManager,
            JiraAuthenticationContext authenticationContext) {
        this.urMgr = urMgr;
        this.cfMgr = cfMgr;
        this.globalPermissionManager = globalPermissionManager;
        this.authenticationContext = authenticationContext;
    }

    @SupportedMethods({RequestMethod.GET, RequestMethod.POST})
    @Override
    public String doDefault() throws Exception {
        if (!globalPermissionManager.hasPermission(ADMINISTER, getLoggedInUser())) {
            return PERMISSION_VIOLATION_RESULT;
        }

        if (customFieldId == null || customFieldId.length() == 0) {
            return getRedirect("RichterRegexConfig!default.jspa");
        }

        CustomField field = cfMgr.getCustomFieldObject(customFieldId);
        if (field == null) {
            return getRedirect("RichterRegexConfig!default.jspa");
        }

        CFData data = urMgr.getCFData(customFieldId);
        jqlclause = data.getJql();
        jqlError = data.getUniqueError();
        regexclause = data.getRegex();
        regexerror = data.getRegexError();
        targetcf = data.getTargetCf();
        return INPUT;
    }

    @Override
    @RequiresXsrfCheck
    protected String doExecute() throws Exception {
        if (!globalPermissionManager.hasPermission(ADMINISTER, getLoggedInUser())) {
            return PERMISSION_VIOLATION_RESULT;
        }

        urMgr.setCfJql(customFieldId, jqlclause);
        urMgr.setUniqueError(customFieldId, jqlError);
        urMgr.setCfRegex(customFieldId, trim(regexclause));
        urMgr.setCfRegexError(customFieldId, regexerror);
        urMgr.setCfTarget(customFieldId, targetcf);
        return getRedirect("RichterRegexConfig!default.jspa?saved=true");
    }

    @Override
    protected void doValidation() {
        if (!UrUtils.checkJQL(jqlclause)) {
            addError("jqlclause", authenticationContext.getI18nHelper().getText("hurichter-regex-tester-action-regex-tester-actionplugins.jirarichter-regex-tester-actionregexfield.field.jql.error.invalid"));
        }

        if (!UrUtils.checkRegex(regexclause)) {
            addError("regexclause", authenticationContext.getI18nHelper().getText("hurichter-regex-tester-action-regex-tester-actionplugins.jirarichter-regex-tester-actionregexfield.field.regex.error.invalid"));
        }

        super.doValidation();
    }

    public String getCustomFieldId() {
        return customFieldId;
    }

    public List<CustomField> getCustomFields() {
        return cfMgr.getCustomFieldObjects();
    }

    public String getDefaultTarget() {
        return isBlank(targetcf) ? customFieldId : targetcf;
    }

    public String getJqlclause() {
        return jqlclause;
    }

    public String getRegexclause() {
        return regexclause;
    }

    public String getRegexerror() {
        return regexerror;
    }

    public String getTargetcf() {
        return targetcf;
    }

    public String getTitle() {
        return authenticationContext.getI18nHelper().getText("hurichter-regex-tester-action-regex-tester-actionplugins.jirarichter-regex-tester-actionregexfield.fields.title", UrUtils.getCfName(cfMgr, customFieldId));
    }

    public void setCustomFieldId(String customFieldId) {
        this.customFieldId = customFieldId;
    }

    public void setJqlclause(String jqlclause) {
        this.jqlclause = jqlclause;
    }

    public void setRegexclause(String regexclause) {
        this.regexclause = regexclause;
    }

    public void setRegexerror(String regexerror) {
        this.regexerror = regexerror;
    }

    public void setTargetcf(String targetcf) {
        this.targetcf = targetcf;
    }

    public String getJqlError() {
        return jqlError;
    }

    public void setJqlError(String jqlError) {
        this.jqlError = jqlError;
    }
}
