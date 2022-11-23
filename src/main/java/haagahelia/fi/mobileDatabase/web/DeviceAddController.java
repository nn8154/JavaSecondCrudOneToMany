package haagahelia.fi.mobileDatabase.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import haagahelia.fi.mobileDatabase.domain.Device;

@Controller
public class DeviceAddController {
	
	
	/* Ensimmäinen tapa */
	private ArrayList<String> devices = new ArrayList<>();

	@GetMapping("/device1")
	public String handleDevices(@RequestParam(name = "nimi", required = false) String name, Model model) {
		if (name != null) {
			devices.add(name);
		}
		model.addAttribute("devices", devices);
		return "devices1";
	}
	
	
	/* Toinen tapa */
	private ArrayList<Device> devices2 = new ArrayList<>();

	@GetMapping(value = "/device2")
	public String handleDevices2(Model model) {
		model.addAttribute("devicesList2", devices2);
		model.addAttribute("device2", new Device());
		return "devices2";
	}

	@PostMapping("/device2")
	public String addDevice(Device device2) {
		devices2.add(device2);
		return "redirect:/device2";
	}

}
