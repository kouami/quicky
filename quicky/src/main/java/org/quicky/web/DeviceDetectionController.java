package org.quicky.web;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceDetectionController {
	
	@RequestMapping("/detect-device")
    public @ResponseBody String detectDevice(Device device) {
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser!";
    }
	
	@RequestMapping("/site-preference")
    public @ResponseBody String home(SitePreference sitePreference) {
        if (sitePreference != null) {
            return "Hello " + sitePreference.name() + " site preference!";
        } else {
            return "SitePreference is not configured.";
        }
    }
	
}
