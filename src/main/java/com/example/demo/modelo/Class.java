package com.example.demo.modelo;

public class Class {
//
//	//sequence
//	@Id
//		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_seq")
//		@SequenceGenerator(name = "estu_seq", sequenceName = "estu_seq", allocationSize = 1)
//		@Column(name = "estu_id")
//		private Integer id;
//	//Relaciones
//	ONE TO ONE
//	/////////////
//	--Clase principal
//	@OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL) //Alumno es la clase principal
//	private Examen examen;
//	--Clase secundaria
//	@OneToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "exa_id_alumno")
//		private Alumno alumno;
//	//////////
//	ONE TO MANY
//	--Clase principal
//	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  //pongo el nombre del objeto que cree en la otra clase
//		private List<Pedido> pedidos;
//		--METODO BUSCAR
//			Cliente cli = this.eM.find(Cliente.class, id);
//			//Con el Size el framework identifica que vamos a usar las habitaciones
//			cli.getPedidos().size();
//			return cli;
//	--Clase secundaria
//	@ManyToOne(cascade = CascadeType.ALL) 
//		@JoinColumn(name="ped_id_cliente") 
//		private Cliente cliente;
//	//////////
//	MANY TO MANY
//	--Clase principal
//	@ManyToMany(mappedBy = "clientes", cascade = CascadeType.ALL) 
//		private Set<Vehiculo> vehiculos;
//	--Clase secundaria
//	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//		@JoinTable(name="vehiculo_cliente", 
//		joinColumns = @JoinColumn(name ="vecl_id_vehiculo"), //Ponemos el nombre de la tabla de rompimiento
//		inverseJoinColumns = @JoinColumn(name= "vecl_id_cliente")) //La pk de autor
//		private Set<Cliente> clientes;
//	//Queries
//	EN LA CLASE DEL MODELO 
//	@NamedQueries({@NamedQuery(name = "Estudiante.buscarPNNQ", query = "select e from Estudiante e where e.nombre = :datoNombre"),
//				  @NamedQuery(name = "Estudiante.buscarPNNQ1", query = "select e from Estudiante e where e.nombre = :datoNombre"), 
//				   @NamedQuery(name = "Estudiante.buscarPNNQ2", query = "select e from Estudiante e where e.nombre = :datoNombre")})
//
//	@NamedNativeQueries({@NamedNativeQuery(name="Estudiante.buscarPNNNQ",query="select * from estudiante where estu_nombre=:datoNombre", resultClass = Estudiante.class),
//						@NamedNativeQuery(name="Estudiante.buscarPNNNQ1",query="select * from estudiante where estu_nombre=:datoNombre",resultClass = Estudiante.class),
//						 @NamedNativeQuery(name="Estudiante.buscarPNNNQ2",query="select * from estudiante where estu_nombre=:datoNombre",resultClass = Estudiante.class)})
//	//////////
//	QUERY-->Retorna un generico
//
//			Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
//			jpqlQuery.setParameter("datoNombre", nombre);
//			return (Estudiante) jpqlQuery.getSingleResult();
//	///////////
//	TypedQuery---> Tipo de objeto
//
//	TypedQuery<Estudiante> myTypedQuery = this.entityManager.
//					createQuery("select e from Estudiante e where e.nombre = :datoNombre",Estudiante.class);
//			myTypedQuery.setParameter("datoNombre", nombre);
//			//No hay que castear. Recibo directamente el tipo específico
//			return myTypedQuery.getSingleResult();
//	////////
//	NamedQuery--->Lo llamo por el nombre
//
//	Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPNNQ");
//			myQuery.setParameter("datoNombre", nombre);
//			
//			return (Estudiante) myQuery.getSingleResult();
//	//////
//	NamedQueryTyped
//
//	TypedQuery<Estudiante> myTypedQuery = this.entityManager.
//					createNamedQuery("Estudiante.buscarPNNQ",Estudiante.class);
//			myTypedQuery.setParameter("datoNombre", nombre);
//			return myTypedQuery.getSingleResult();
//	///////
//	Native--->SQL Nativo
//
//	Query myQuery = this.entityManager.
//					createNativeQuery("select * from estudiante where estu_nombre=:datoNombre", Estudiante.class);
//			myQuery.setParameter("datoNombre", nombre);
//			
//			return (Estudiante) myQuery.getSingleResult();
//	//////
//	NativeNamedTyped Query
//
//	TypedQuery<Estudiante> myQuery = this.entityManager.
//					createNamedQuery("Estudiante.buscarPNNNQ", Estudiante.class);
//			myQuery.setParameter("datoNombre", nombre);
//			
//			return myQuery.getSingleResult();
//	////
//	PRIMER ELEMENTO DE UNA LISTA
//
//	Query jpqlQuery=this.entityManager.
//						createQuery("select e from Estudiante e where e.nombre = :datoNombre");
//				jpqlQuery.setParameter("datoNombre",nombre);
//
//				return (Estudiante) jpqlQuery.getResultList().get(0);
//	////
//	DTO
//
//	TypedQuery<EstudianteDTO> myTypedQuery = this.entityManager
//						 .createQuery("select NEW com.example.demo.modelo.dto.EstudianteDTO (e.nombre, e.apellido, e.cedula )
//						 from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
//						 myTypedQuery.setParameter("datoNombre", nombre);
//						return myTypedQuery.getSingleResult();
//	//////
//	Criteria API Query
//
//	CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
//				//Especificamos el tipo de retorno del query
//				CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
//				//Luego, creamos el SQL definiendo el FROM-Root (Método)
//				Root<Estudiante> myTable = myQuery.from(Estudiante.class);
//				//Las condiciones WHERE aquí se conocen como "predicados"
//				Predicate condicion = myBuilder.equal(myTable.get("nombre"), nombre);//Ponemos el nombre del atributo
//				//Finalmente, declaramos el Query
//				myQuery.select(myTable).where(condicion);
//				//Ahora, ejecutamos con cualquier tipo ya conocido. De preferencia, TYPEDQuery
//				TypedQuery<Estudiante> mQ = this.entityManager.createQuery(myQuery);
//				
//				return mQ.getResultList(); 
//	///////
//	Critera AND & OR (List)---> Y las condiciones where La bandera pasa como parametro
//
//				CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
//				//Especificamos el tipo de retorno del query
//				CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
//				//Luego, creamos el SQL definiendo el FROM-Root (Método)
//				Root<Estudiante> myTable = myQuery.from(Estudiante.class);
//				
//				//Las condiciones WHERE aquí se conocen como "predicados"
//				//Armado dinámico. Ejemplo:
//				//M: e.nombre = AND e.apellido=
//				//F: e.nombre = OR e.apellido=
//				
//				Predicate condicion = myBuilder.equal(myTable.get("nombre"), nombre);
//				Predicate condicion1 = myBuilder.equal(myTable.get("apellido"), apellido);	
//				//Para la comparación del AND y el Or, tenemos que hacer otro predicado
//				
//				
//				Predicate predicadoFinal = null;
//				if(bandera.equals("M")) {
//					predicadoFinal = myBuilder.and(condicion, condicion1);
//				}else {
//					predicadoFinal = myBuilder.or(condicion, condicion1);
//				}
//
//				
//				myQuery.select(myTable).where(predicadoFinal);
//				//Ahora, ejecutamos con cualquier tipo ya conocido. De preferencia, TYPEDQuery
//				TypedQuery<Estudiante> mQ = this.entityManager.createQuery(myQuery);
//				return mQ.getResultList();
//
//	//////
//	DELETE
//	Query query = this.entityManager.createQuery("DELETE FROM Estudiante e where e.apellido=:datoApellido"); 
//				query.setParameter("datoApellido", apellido);
//				return query.executeUpdate();
//	//////
//	UPDATE--->Paramaetro por el que busco y el que quiero cambiar
//	Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre=: datoNombre WHERE e.apellido=:datoApellido");
//				query.setParameter("datoNombre", nombre);
//				query.setParameter("datoApellido", apellido);
//				
//				return query.executeUpdate();
//
//	//Joins
//	////////
//	INNER JOIN--->Interseccion
//	CLASE PRINCIPAL
//
//	TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha "
//					+ "WHERE ha.tipo=:datoTipo",Hotel.class);
//			myQuery.setParameter("datoTipo", tipoHabitacion);
//
//			List <Hotel> listaHoteles=myQuery.getResultList();
//			//BAJO DEMANDA
//			for (Hotel h:listaHoteles) {
//				List<Habitacion> listaTMP=new ArrayList<>();
//				for(Habitacion ha:h.getHabitaciones()) {
//					if(ha.getTipo().equals(tipoHabitacion)) {
//						listaTMP.add(ha);
//					}
//				}
//				h.setHabitaciones(listaTMP);
//
//			}
//	///////
//	OUTER LEFT Y RIGHT
//	TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha "
//					+ "WHERE ha.tipo=:datoTipo",Hotel.class);
//			myQuery.setParameter("datoTipo", tipoHabitacion);
//
//			return myQuery.getResultList();
//	//////
//	FETCH
//			TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha "
//					+ "WHERE ha.tipo=:datoTipo",Hotel.class);
//			myQuery.setParameter("datoTipo", tipoHabitacion);
//
//
//			return myQuery.getResultList();
//	////
//	OUTER SIN PARAMETROS
//	(RIGHT)
//			TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha ",Hotel.class);
////			List<Hotel> lista = myQuery.getResultList();
////			for(Hotel h: lista) {
////				h.getHabitaciones().size();
////			}
//			return myQuery.getResultList();
//
//			return listaHoteles;
//	///////
//	CLASE SECUNDARIA
//	TypedQuery<Habitacion> myQuery=this.entityManager
//					.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha ",Habitacion.class);
//			List<Habitacion> lista = myQuery.getResultList();
//		
//			return lista;
}
