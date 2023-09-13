package hu.plugins.jira.customfields.action.field;

import com.atlassian.jira.config.managedconfiguration.ManagedConfigurationItemService;
import com.atlassian.jira.web.action.admin.customfields.AbstractEditConfigurationItemAction;

public class RegexCFRegexConfigAction extends AbstractEditConfigurationItemAction {
    public RegexCFRegexConfigAction(ManagedConfigurationItemService managedConfigurationItemService) {
        super(managedConfigurationItemService);
    }
}
