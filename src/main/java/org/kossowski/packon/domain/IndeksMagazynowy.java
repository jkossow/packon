package org.kossowski.packon.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table( name = "indeksy_magazynowe")
public class IndeksMagazynowy {

		@Id @GeneratedValue
		@Column( name = "id", nullable = true)
		private Long id;

		@Column( name = "uuid")
		UUID uuid = UUID.randomUUID(); 
		
		
		@NotNull
		@Column( unique = true)
		private String indeks;
		
		private String nazwa;
		
		
		@ManyToOne
		private Jm jednMiary;
		
		@ManyToMany
		private Set<IndeksMagazynowy> materials = new HashSet<>();
		
		@ManyToMany
		private List<Operacja> technologia = new ArrayList<>();  
		
		
		private Boolean wyrobGotowy;
		private Boolean material;

		private String wymiarPalety;
		private String klisza;
		private String wykrojnik;
		private BigInteger iloscStukNaPalecie;
		
		public Long getId() {
			return id;
		}
		
		
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public String getIndeks() {
			return indeks;
		}
		
		
		public void setIndeks(String indeks) {
			this.indeks = indeks;
		}
		
		
		public String getNazwa() {
			return nazwa;
		}
		
		
		public void setNazwa(String nazwa) {
			this.nazwa = nazwa;
		}
		
		
		public Boolean getWyrobGotowy() {
			return wyrobGotowy;
		}
		
		
		public void setWyrobGotowy(Boolean wyrobGotowy) {
			this.wyrobGotowy = wyrobGotowy;
		}
		
		
		public Boolean getMaterial() {
			return material;
		}
		
		
		public void setMaterial(Boolean material) {
			this.material = material;
		}


		/**
		 * @return the uuid
		 */
		public UUID getUuid() {
			return uuid;
		}


		/**
		 * @param uuid the uuid to set
		 */
		public void setUuid(UUID uuid) {
			this.uuid = uuid;
		}


		/**
		 * @return the wymiarPalety
		 */
		public String getWymiarPalety() {
			return wymiarPalety;
		}


		/**
		 * @param wymiarPalety the wymiarPalety to set
		 */
		public void setWymiarPalety(String wymiarPalety) {
			this.wymiarPalety = wymiarPalety;
		}


		/**
		 * @return the klisza
		 */
		public String getKlisza() {
			return klisza;
		}


		/**
		 * @param klisza the klisza to set
		 */
		public void setKlisza(String klisza) {
			this.klisza = klisza;
		}


		/**
		 * @return the wykrojnik
		 */
		public String getWykrojnik() {
			return wykrojnik;
		}


		/**
		 * @param wykrojnik the wykrojnik to set
		 */
		public void setWykrojnik(String wykrojnik) {
			this.wykrojnik = wykrojnik;
		}


		/**
		 * @return the iloscStukNaPalecie
		 */
		public BigInteger getIloscStukNaPalecie() {
			return iloscStukNaPalecie;
		}


		/**
		 * @param iloscStukNaPalecie the iloscStukNaPalecie to set
		 */
		public void setIloscStukNaPalecie(BigInteger iloscStukNaPalecie) {
			this.iloscStukNaPalecie = iloscStukNaPalecie;
		}

		
		
		

		/**
		 * @return the jednMiary
		 */
		public Jm getJednMiary() {
			return jednMiary;
		}


		/**
		 * @param jednMiary the jednMiary to set
		 */
		public void setJednMiary(Jm jednMiary) {
			this.jednMiary = jednMiary;
		}

		
		

		/**
       * @return the materials
       */
      public Set<IndeksMagazynowy> getMaterials() {
         return materials;
      }


      /**
       * @param materials the materials to set
       */
      public void setMaterials(Set<IndeksMagazynowy> materials) {
         this.materials = materials;
      }


      /* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
			return result;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof IndeksMagazynowy))
				return false;
			IndeksMagazynowy other = (IndeksMagazynowy) obj;
			if (uuid == null) {
				if (other.uuid != null)
					return false;
			} else if (!uuid.equals(other.uuid))
				return false;
			return true;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "IndeksMagazynowy [id=" + id + ", uuid=" + uuid + ", indeks=" + indeks + ", nazwa=" + nazwa
					+ ", wyrobGotowy=" + wyrobGotowy + ", material=" + material + ", wymiarPalety=" + wymiarPalety
					+ ", klisza=" + klisza + ", wykrojnik=" + wykrojnik + ", iloscStukNaPalecie=" + iloscStukNaPalecie
					+ "]";
		}
	
		
		
		
		
}
