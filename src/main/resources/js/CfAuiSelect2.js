/*
#controlHeader ($action $customField.id $customField.name $fieldLayoutItem.required $displayParameters.noHeader)
$webResourceManager.requireResource("com.atlassian.auiplugin:aui-select2")

<script type="text/javascript">
    AJS.toInit(function() {
        AJS.$("#$customField.id").select2();
    });
</script>

<select name="$customField.id" id="$customField.id" multiple>

    #foreach ($option in $options)
        <option value="$option">$option</option>
    #end
</select>

#controlFooter ($action $fieldLayoutItem.fieldDescription $displayParameters.noHeader)
*/
/*
<script type="text/javascript">
  AJS.toInit(function () {
  AJS.$("#$customField.id").auiSelect2();
});
</script>
*/
