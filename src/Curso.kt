class Curso( // esse construtor primario sera usado na intancia a ser realizada no metodo registrarCurso da classe DigitalHouseManager
    val nome: String,
    val codigoCurso: Int,
    val qtdeMaximaAlunos: Int
) {
    // construtor secundario que sera usado no método alocarProfessores da classe DigitalHouseManager
    var profTitular = ProfessorTitular("", "", 0, 0,"")
    var profAdjunto = ProfessorAdjunto("", "", 0, 0, 0)
    constructor(nome: String, codigoCurso: Int, qtdeMaximaAlunos: Int, profTitular: ProfessorTitular, profAdjunto: ProfessorAdjunto): this(nome, codigoCurso, qtdeMaximaAlunos){
        this.profTitular = profTitular
        this.profAdjunto = profAdjunto
    }
    // terceiro construtor que sera usado no metodo adicionarUmAluno
    var alunosMatriculados: MutableList<Aluno> = mutableListOf()
    constructor(nome: String, codigoCurso: Int, qtdeMaximaAlunos: Int, alunosMatriculados: MutableList<Aluno>): this(nome, codigoCurso, qtdeMaximaAlunos){
        this.alunosMatriculados = alunosMatriculados
    }

    override fun equals(other: Any?): Boolean {
        val umCurso = other as? Curso
        return when(other) {
            is Curso -> {
                this.codigoCurso == umCurso?.codigoCurso
            }
            is Double -> {
                true
            }
            else -> {
                super.equals(other)
            }
        }
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        if( qtdeMaximaAlunos > alunosMatriculados.size){
            alunosMatriculados.add(umAluno)
            println("${umAluno.nome} foi matriculada(o) com sucesso no curso de $nome")
            return true
        } else{
            println("Não foi possível matricular ${umAluno.nome} nesse curso pois a quantidade máxima de alunos foi atingida!")
            return false
        }
    }
    fun excluirAluno(umAluno: Aluno){
        alunosMatriculados.remove(umAluno)
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + codigoCurso
        result = 31 * result + qtdeMaximaAlunos
        result = 31 * result + profTitular.hashCode()
        result = 31 * result + profAdjunto.hashCode()
        result = 31 * result + alunosMatriculados.hashCode()
        return result
    }
}