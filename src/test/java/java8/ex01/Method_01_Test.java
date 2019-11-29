package java8.ex01;

import java.util.ArrayList;
import java.util.List;

import javax.management.ListenerNotFoundException;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;
import java8.ex01.Method_01_Test.IDao;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		/**
		 * @return retourne le résultat de l'addition des ages des personnes
		 */
		default int sumAge() {
			int result = 0;
			List<Person> listePerson = findAll();
			for (Person p : listePerson) {
				result += p.getAge();
			}
			return result;
		}

	}

	// end::IDao[]

	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

	}

	class DaoB implements IDao {

		List<Person> people = Data.buildPersonList(100);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

		@Test
		public void test_daoA_sumAge() throws Exception {

			DaoA daoA = new DaoA();


			int result = daoA.sumAge();

			assert result == 210;
		}

		@Test
		public void test_daoB_sumAge() throws Exception {

			DaoB daoB = new DaoB();

			// TODO invoquer la méthode sumAge pour que le test soit passant
			int result = daoB.sumAge();

			assert result == 5050;

		}
}
