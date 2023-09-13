package hu.plugins.jira.customfields.action.admin;

import com.atlassian.jira.security.xsrf.RequiresXsrfCheck;

import java.util.regex.Pattern;

import static com.atlassian.jira.permission.GlobalPermissionKey.ADMINISTER;

import com.atlassian.jira.security.request.RequestMethod;
import com.atlassian.jira.security.request.SupportedMethods;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import webwork.action.ServletActionContext;
import javax.servlet.http.HttpServletResponse;

@SupportedMethods({RequestMethod.GET, RequestMethod.POST})
public class RegexTesterAction extends JiraWebActionSupport {
    private static final String NOT_SET = "NOTSET";

    private String regex;
    private String expression;
    private String matched;

    @Override
    public String doDefault() {
        if (!hasAdminPermission()) {
            return PERMISSION_VIOLATION_RESULT;
        }
        matched = NOT_SET;
        return INPUT;
    }

    @Override
    @RequiresXsrfCheck
    @SupportedMethods({RequestMethod.GET, RequestMethod.POST})
    protected String doExecute() {
        if (!hasAdminPermission()) {
            return PERMISSION_VIOLATION_RESULT;
        }

        if (Pattern.compile(regex).matcher(expression).matches()) {
            matched = "OK";
        } else {
            matched = "FAIL";
        }

        return SUCCESS;
    }

    @Override
    protected void doValidation() {
        matched = NOT_SET;

        if (regex == null || regex.isEmpty()) {
            addError("regex", getText("huregex-tester-action-regex-tester-actionplugins.jiraregex-tester-actionregexfield.tester.regex.error.empty"));
        } else {
            try {
                Pattern.compile(regex);
            } catch (Exception ex) {
                addError("regex", getText("huregex-tester-action-regex-tester-actionplugins.jiraregex-tester-actionregexfield.tester.regex.error.invalid"));
            }
        }

        super.doValidation();
    }

    private boolean hasAdminPermission() {
        return getGlobalPermissionManager().hasPermission(ADMINISTER, getLoggedInUser());
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getMatched() {
        return matched;
    }

    public void setMatched(String matched) {
        this.matched = matched;
    }
}
