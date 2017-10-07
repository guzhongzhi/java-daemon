<#assign base=request.contextPath />
<@override name="head_title">
fdsafdsa - <@super/>
</@override>

<@override name="body">
    <#list navigation as category>
    <div>
        <div>
            ${category.title}
        </div>
        <div>
            <#list category.topNews as news>
            ${news.title}<br/>
            </#list>
        </div>
    </div>
    </#list>
</@override>


<@extends name="layout.ftl"/>



