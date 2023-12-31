package hu.plugins.jira.customfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.SelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import hu.plugins.jira.customfields.service.ColorResolver;

import javax.annotation.Nonnull;
import java.util.Map;

public class LocalColorCustomField extends SelectCFType {
    private final ColorResolver colorResolver;

    public LocalColorCustomField(
            CustomFieldValuePersister customFieldValuePersister,
            OptionsManager optionsManager,
            GenericConfigManager genericConfigManager,
            JiraBaseUrls jiraBaseUrls,
            ColorResolver colorResolver) {
        super(customFieldValuePersister, optionsManager, genericConfigManager, jiraBaseUrls);
        this.colorResolver = colorResolver;
    }

    @Override
    @Nonnull
    public Map<String, Object> getVelocityParameters(
            Issue issue,
            CustomField customField,
            FieldLayoutItem fieldLayoutItem) {
        Map<String, Object> map = super.getVelocityParameters(issue, customField, fieldLayoutItem);
        map.put("colorResolver", colorResolver);

        if (issue == null) {
            return map;
        }

        Object color = issue.getCustomFieldValue(customField);
        if (color != null) {
            map.put("colorHex", colorResolver.resolveColor(color.toString()));
        }
        return map;
    }
}