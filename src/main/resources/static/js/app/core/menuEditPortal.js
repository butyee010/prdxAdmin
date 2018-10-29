var menuEditPortal = {
    
    url_portal: {
        PAGE_HOME : "edit/editHome",
        PAGE_ABOUT : "edit/editAbout",
        PAGE_SERVICES : "edit/editServices",
        PAGE_OUR_WORKS : "edit/editOurWorks",
        PAGE_GALLERY : "edit/editGallery",
        PAGE_CONTACT : "edit/editContact",
    },

    editPortalAction: function(menuKey) {
    	var portalUrl = menuEditPortal.url_portal[menuKey];
    	if (!!portalUrl) {
    		ajaxCall({
                type: 'POST',
    			url: portalUrl,
    			replaceid: '#container',
    			onSuccess: function() {
    				
    			}
    		});
        }
     },

}