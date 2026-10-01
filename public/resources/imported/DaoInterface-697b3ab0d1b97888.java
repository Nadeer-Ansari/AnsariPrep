package example.jdbc;

import java.util.Collection;

public interface DaoInterface<Type, ID> {
	void create(Type newEntity);
	Collection<Type> retrieveAll();
	Type retrieveById(ID entityId);
	void update(Type updatedEntity);
	void deleteById(ID entityId);
}
//Type => Type of Entity
//ID => Type of Entitie's Identity
