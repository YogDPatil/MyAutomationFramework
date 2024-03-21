package com.api.pojo;

import com.github.javafaker.Faker;
import com.utils.TestUtils;

public final class ApiRequestBody {
	Faker faker = new Faker();
	public String getCreateJobApiRequestBody() {
		
		String imei = faker.numerify("1###############");
		String createJob ="{\n"
				+ "    \"mst_service_location_id\": 0,\n"
				+ "    \"mst_platform_id\": 2,\n"
				+ "    \"mst_warrenty_status_id\": 1,\n"
				+ "    \"mst_oem_id\": 1,\n"
				+ "    \"customer\": {\n"
				+ "        \"first_name\": \""+faker.name().firstName()+"\",\n"
				+ "        \"last_name\": \""+faker.name().lastName()+"\",\n"
				+ "        \"mobile_number\": \""+faker.numerify("9#########")+"\",\n"
				+ "        \"mobile_number_alt\": \"\",\n"
				+ "        \"email_id\": \""+faker.internet().emailAddress()+"\",\n"
				+ "        \"email_id_alt\": \""+faker.internet().emailAddress()+"\"\n"
				+ "    },\n"
				+ "    \"customer_address\": {\n"
				+ "        \"flat_number\": \"135\",\n"
				+ "        \"apartment_name\": \"33166\",\n"
				+ "        \"street_name\": \"9072 Marvin Point\",\n"
				+ "        \"landmark\": \"9603\",\n"
				+ "        \"area\": \"New Ashleyfort\",\n"
				+ "        \"pincode\": \"6959689\",\n"
				+ "        \"country\": \"Maharashtra\",\n"
				+ "        \"state\": \"India\"\n"
				+ "    },\n"
				+ "    \"customer_product\": {\n"
				+ "        \"dop\": \"2023-06-10T18:30:00.000Z\",\n"
				+ "        \"serial_number\": \""+imei+"\",\n"
				+ "        \"imei1\": \""+imei+"\",\n"
				+ "        \"imei2\": \""+imei+"\",\n"
				+ "        \"popurl\": \"2023-06-10T18:30:00.000Z\",\n"
				+ "        \"product_id\": 1,\n"
				+ "        \"mst_model_id\": 1\n"
				+ "    },\n"
				+ "    \"problems\": [\n"
				+ "        {\n"
				+ "            \"id\": 1,\n"
				+ "            \"remark\": \"Phone not working\"\n"
				+ "        }\n"
				+ "       \n"
				+ "    ]\n"
				+ "}";
		System.out.println(createJob);
		return createJob;
	}
}
