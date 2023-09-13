package hu.plugins.jira.customfields.action.field;

import com.atlassian.jira.config.managedconfiguration.ManagedConfigurationItemService;
import com.atlassian.jira.web.action.admin.customfields.AbstractEditConfigurationItemAction;

public class RichterRegexCFUniqueConfigAction extends AbstractEditConfigurationItemAction {
    public RichterRegexCFUniqueConfigAction(ManagedConfigurationItemService managedConfigurationItemService) {
        super(managedConfigurationItemService);
    }
}
