package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.VendorDao;

public class GetAllVendorDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			VendorDao dao = new VendorDao();
			dao.getAllVendors().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
