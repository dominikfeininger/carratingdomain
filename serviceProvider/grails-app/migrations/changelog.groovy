databaseChangeLog = {

	changeSet(author: "Administrator (generated)", id: "1342628005343-1") {
		createTable(tableName: "location") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "locationPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Administrator (generated)", id: "1342628005343-2") {
		createTable(tableName: "place") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "placePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
