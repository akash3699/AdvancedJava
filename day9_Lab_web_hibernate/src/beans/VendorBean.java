package beans;

import java.util.ArrayList;
import java.util.List;

import dao.VendorDaoImpl;
import pojos.Vendor;

public class VendorBean {
	private int id;
	private VendorDaoImpl dao = null;
	private List<Vendor> l1=new ArrayList<>();
	private Vendor v;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VendorDaoImpl getDao() {
		return dao;
	}

	public void setDao(VendorDaoImpl dao) {
		this.dao = dao;
	}

	public Vendor getV() {
		return v;
	}

	public void setV(Vendor v) {
		this.v = v;
	}

	public VendorBean() {
		dao = new VendorDaoImpl();
		
	}

	public List<Vendor> getL1() {
		return l1;
	}

	public void setL1(List<Vendor> l1) {
		this.l1 = l1;
	}
	
	public Vendor fetchAllVendorsWithLocation()
	{
		return dao.getVendorDetailsById(id);
	}
	
	public List<Vendor> fetchAllVendors()
	{
		return dao.getAllVendorDetails();
	}
	public Vendor fetchAllVendorsWithAccounts()
	{
		return dao.getVendorDetailsByIdWithAccounts(id);
	}
	
}
