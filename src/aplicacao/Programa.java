package aplicacao;

import java.util.Date;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("======TESTE 1: seller findById========");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n======TESTE 2: seller findByDepartment========");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n======TESTE 3: seller findByAll========");
		
	    list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);

	}
		System.out.println("\n======TESTE 4: seller insert========");
		Seller newSeller = new Seller (null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserir! New id " + newSeller.getId());
		
		System.out.println("\n======TESTE 5: seller update========");
		seller = sellerDao.findById(13);
		seller.setName("Humberto de Castro");		
		sellerDao.update(seller);
		System.out.println("Update completo");
		
		System.out.println("\n======TESTE 6: seller deletar========");
		System.out.println("Entre com id para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete completado");
		sc.close();
	}
}


