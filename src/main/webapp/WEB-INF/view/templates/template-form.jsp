<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2><tiles:insertAttribute name="title"></tiles:insertAttribute></h2>
    <tiles:insertAttribute name="form"></tiles:insertAttribute>
</article>