package com.springcore.hibernate2;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Lockers;
import entity.Bank;
import entity.Cities;
import entity.AccessCode;

public class App 
{
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session s= sf.openSession();
        s.beginTransaction();

        // bank1
        Bank bank1 = new Bank();
        bank1.setName("SBI");
        
        Bank bank2 = new Bank();
        bank2.setName("CANARA");
        
        Bank bank3 = new Bank();
        bank3.setName("PNB");
        
        Bank bank4 = new Bank();
        bank4.setName("AXIS");

        //Lockers
        Lockers locker1 = new Lockers();
        locker1.setName("locker101");
        locker1.setBank(bank1);

        Lockers locker2 = new Lockers();
        locker2.setName("locker201");
        locker2.setBank(bank2);
        
        Lockers locker3 = new Lockers();
        locker3.setName("locker301");
        locker3.setBank(bank3);
        
        Lockers locker4 = new Lockers();
        locker4.setName("locker401");
        locker4.setBank(bank4);

        // Access Codes
        AccessCode accessCode1=new AccessCode();
        accessCode1.setAccessCodeValue("WR9KLW");
        accessCode1.setLocker(locker1);

        AccessCode accessCode2=new AccessCode();
        accessCode2.setAccessCodeValue("KLW89R");
        accessCode2.setLocker(locker2);
        
        AccessCode accessCode3=new AccessCode();
        accessCode3.setAccessCodeValue("K7U50R");
        accessCode3.setLocker(locker3);
        
        AccessCode accessCode4=new AccessCode();
        accessCode4.setAccessCodeValue("I9Y50R");
        accessCode4.setLocker(locker4);

        locker1.setAccessCode(accessCode1);
        locker2.setAccessCode(accessCode2);
        locker3.setAccessCode(accessCode3);
        locker4.setAccessCode(accessCode4);
        
        //Cities
        Cities city1 = new Cities();
        city1.setName("JAIPUR");

        Cities city2 = new Cities();
        city2.setName("MUMBAI");

        //setting values
        bank1.setLockers(Arrays.asList(locker1, locker2,locker3, locker4));
        bank1.setCities(Arrays.asList(city2));
        bank2.setCities(Arrays.asList(city1, city2));

        
        s.persist(bank1);
        s.persist(bank2);
        s.persist(bank3);
        s.persist(bank4);
        s.persist(locker1);
        s.persist(locker2);
        s.persist(locker3);
        s.persist(locker4);
        s.persist(accessCode1);
        s.persist(accessCode2);
        s.persist(accessCode3);
        s.persist(accessCode4);
        s.persist(city1);
        s.persist(city2);
        
        s.getTransaction().commit();
        
        Bank n = s.find(Bank.class, bank1.getId());
        
        System.out.println(" One To One Relationship:\n");
        
        Lockers u1=s.find(Lockers.class, locker1.getId());
        System.out.println("AccessCode for locker "+u1.getName()+" is "+u1.getAccessCode().getAccessCodeValue());

        Lockers u2=s.find(Lockers.class, locker2.getId());
        System.out.println("AccessCode for locker "+u2.getName()+" is "+u2.getAccessCode().getAccessCodeValue());
        
        System.out.println(" One To Many Relationship:\n");

        System.out.println("One " + n.getName() + " Bank is used by:");
        for (Lockers lockers : n.getLockers()) {
            System.out.println(lockers.getName());
        }
        
        System.out.println(" Many To One Relationship:\n");
        
        for (Lockers lockers : n.getLockers()) {
        	System.out.println(lockers.getName() + " is having Bank: "+bank1.getName());
        }
        
        System.out.println(" Many To Many Relationship:\n");
        
        System.out.println("Bank "+ n.getName() +" available in :");
        for (Cities city : n.getCities()) {
            System.out.print(city.getName()+". ");
        }
        
        Bank n2 = s.find(Bank.class, bank2.getId());
        System.out.println("\n\nBank "+ n2.getName() +" available in :");
        for (Cities cities : n2.getCities()) {
            System.out.print(cities.getName()+". ");
        }
        
        s.close();
    }
}

