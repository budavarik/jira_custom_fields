package hu.local.plugins.jira.customfields.action.field;

import com.atlassian.jira.config.managedconfiguration.ManagedConfigurationItemService;
import com.atlassian.jira.web.action.admin.customfields.AbstractEditConfigurationItemAction;

public class RichterRegexCFRegexConfigAction extends AbstractEditConfigurationItemAction {
    public RichterRegexCFRegexConfigAction(ManagedConfigurationItemService managedConfigurationItemService) {
        super(managedConfigurationItemService);
    }
}