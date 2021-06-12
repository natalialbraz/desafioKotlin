abstract class Professor{
    abstract val nome: String
    abstract val sobrenome: String
    abstract val tempoDeCasa: Int
    abstract val codigoProfessor: Int


    override fun equals(other: Any?): Boolean {
        val umProfessor = other as? Professor
        return when(other) {
            is Professor -> {
                this.codigoProfessor == umProfessor?.codigoProfessor
            }
            is Double -> {
                true
            }
            else -> {
                super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + sobrenome.hashCode()
        result = 31 * result + tempoDeCasa
        result = 31 * result + codigoProfessor
        return result
    }
}