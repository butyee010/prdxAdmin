var menuPortal = {
    
    opts: {},
    
    url_portal: {
        PAGE_HOME : "home",
        PAGE_ABOUT : "about",
        PAGE_SERVICES : "services",
        PAGE_OUR_WORKS : "ourWorks",
        PAGE_GALLERY : "gallery",
        PAGE_CONTACT : "contact",
    },

    initialize: function(dataOpts) {
        menuPortal.opts = $.extend( menuPortal.opts , dataOpts );
    },

    menuPortalAction: function(menuKey, elm) {
    	var portalUrl = menuPortal.url_portal[menuKey];
    	if (!!portalUrl) {
    		ajaxCall({
                type: 'POST',
    			url: portalUrl,
    			replaceid: '#container',
    			onSuccess: function() {
    			}
    		});
        }
        
        if (!!elm && elm != 'back') {
            $(elm).parents("ul").find("li.active").removeClass("active");
            $(elm).parents("li").addClass("active");
        }
        else if(!elm) {
            $(".navbar-nav").find("li.active").removeClass("active");
        }
     },
}