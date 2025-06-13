    package view;

    import dao.AlunoDAO;
    import model.Aluno;

    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.util.List;

    public class AlunoForm extends JFrame {
        private JTextField txtNome, txtMatricula, txtCurso, txtEmail;
        private JButton btnSalvar, btnListar, btnRemover;
        private JTable table;
        private DefaultTableModel tableModel;


        public AlunoForm() {
            setTitle("Cadastro de Aluno");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
            inputPanel.setBorder(BorderFactory.createTitledBorder("Novo Aluno"));

            txtNome = new JTextField();
            txtMatricula = new JTextField();
            txtCurso = new JTextField();
            txtEmail = new JTextField();
            btnSalvar = new JButton("Salvar");

            inputPanel.add(new JLabel("Nome:"));
            inputPanel.add(txtNome);
            inputPanel.add(new JLabel("Matrícula:"));
            inputPanel.add(txtMatricula);
            inputPanel.add(new JLabel("Curso:"));
            inputPanel.add(txtCurso);
            inputPanel.add(new JLabel("Email:"));
            inputPanel.add(txtEmail);
            inputPanel.add(new JLabel());
            inputPanel.add(btnSalvar);

            // tabela
            tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Matrícula", "Curso", "Email"}, 0);
            table = new JTable(tableModel);
            JScrollPane tableScroll = new JScrollPane(table);

            // botões
            btnListar = new JButton("Listar Alunos");
            btnRemover = new JButton("Remover Selecionado");
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnListar);
            buttonPanel.add(btnRemover);

            // adiciona tudo ao frame
            setLayout(new BorderLayout());
            add(inputPanel, BorderLayout.NORTH);
            add(tableScroll, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);

            // ações
            btnSalvar.addActionListener(e -> salvarAluno());
            btnListar.addActionListener(e -> listarAlunos());
            btnRemover.addActionListener(e -> removerAluno());
        }

        private void salvarAluno() {
            String nome = txtNome.getText();
            String matricula = txtMatricula.getText();
            String curso = txtCurso.getText();
            String email = txtEmail.getText();

            if (nome.isEmpty() || matricula.isEmpty() || curso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            aluno.setCurso(curso);
            aluno.setEmail(email);

            new AlunoDAO().create(aluno);

            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            limparCampos();
        }

        private void listarAlunos() {
            tableModel.setRowCount(0);
            List<Aluno> alunos = new AlunoDAO().read();
            for (Aluno a : alunos) {
                tableModel.addRow(new Object[]{
                        a.getId(), a.getNome(), a.getMatricula(), a.getCurso(), a.getEmail()
                });
            }
        }

        private void removerAluno() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                new AlunoDAO().delete(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Aluno removido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um aluno para remover.");
            }
        }

        private void limparCampos() {
            txtNome.setText("");
            txtMatricula.setText("");
            txtCurso.setText("");
            txtEmail.setText("");
        }
    }
