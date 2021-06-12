class Aluno(
    val nome: String,
    val sobrenome: String,
    val codigoAluno: Int
){
    override fun equals(other: Any?): Boolean {
        val aluno = other as? Aluno
        return when (other) {
            is Aluno -> {
                this.codigoAluno == aluno?.codigoAluno
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
        result = 31 * result + codigoAluno
        return result
    }
}