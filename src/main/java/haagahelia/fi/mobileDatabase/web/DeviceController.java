package haagahelia.fi.mobileDatabase.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import haagahelia.fi.mobileDatabase.domain.Device;

@Controller
public class DeviceController {

	@GetMapping("device")
	public String showDevice(Model model) {

		model.addAttribute("device1", new Device("Samsung Galaxy", "S21 FE", "5G", "8/256GB", "laventeli"));
		model.addAttribute("device2", new Device("Samsung Galaxy", "S21 FE", "5G", "6/128GB", "oliivi"));
		model.addAttribute("device3", new Device("iPhone12", "12", "5G", "64GB", "valkoinen"));

		
		ArrayList<Device> device = new ArrayList<>();
		
		device.add(new Device("Samsung Galaxy", "S21 FE", "5G", "8/256GB", "laventeli"));
		device.add(new Device("Samsung Galaxy", "S21 FE", "5G", "6/128GB", "oliivi"));
		device.add(new Device("iPhone12", "12", "5G", "64GB", "valkoinen"));
		
		model.addAttribute("deviceList", device);
		return "devices";
	}

}
