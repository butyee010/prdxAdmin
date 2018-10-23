<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<section class="about">
        <section class="row content" style="padding-top: 0">
            <div class="col-sm-12">
                <label class="label-header">${aboutBean.contentHeader1}</label>
                <p>${aboutBean.contentDesc1}</p>
            </div>
        </section>
        <section class="row content">
            <div class="col-sm-4">
                <label class="label-header">${aboutBean.contentHeader2}</label>
                <p>${aboutBean.contentDesc2}</p>
            </div>
            <div class="col-sm-8">
                <label class="label-header">${aboutBean.contentHeader3}</label>
                <p>${aboutBean.contentDesc3}</p>
            </div>
        </section>
        <section class="row content" style="padding-top: 0">
            <div class="col-sm-12">
                <label class="label-header">${aboutBean.contentHeader4}</label>
                <p>${aboutBean.contentDesc4}</p>
            </div>
        </section>
    </section>