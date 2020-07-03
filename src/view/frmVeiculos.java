/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Veiculo;
import dao.VeiculoDAO;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elvis
 */
public class frmVeiculos extends javax.swing.JFrame {

    private VeiculoDAO dao;

    public frmVeiculos() {
        initComponents();
        dao = new VeiculoDAO();
        carregarLista();
    }
    frmClientes janelaCliente = new frmClientes();

    private Veiculo garavaMarcaClasse() {
        Veiculo gravaMC = new Veiculo();
        gravaMC.setMarca(txtMarcaPesq.getText());
        gravaMC.setClasse(txtClassePesq.getText());
        gravaMC.setNome(txtNomePesq.getText());
        return gravaMC;
    }

    private Veiculo gravaVeiculo() {
        Veiculo grav = new Veiculo();
        grav.setNome(txtNomeC.getText());
        grav.setPlaca(txtPlacaC.getText());
        grav.setMarca(txtMarcaC.getText());
        grav.setCor(txtCorC.getText());
        if (rd2portas.isSelected() == true) {

            grav.setPortas("2");
        } else {
            grav.setPortas("4");
        }
        //grav.setPortas(txtPortasC.getText());
        grav.setAno(txtAnoC.getText());
        grav.setPreco(Float.parseFloat(txtValorC.getText()));
        grav.setClasse(txtClasseC.getText());
        if (txtCategoriaC.getSelectedItem() == "Sedan") {

            grav.setCategoria("Sedan");
        } else {
            grav.setCategoria("Hatch");
        }

//grav.setPreco(Float.parseFloat(txtValorC.replace('.','').replace(',','.'));
        //float valor = Float.parseFloat(txtSalario.replace('.','').replace(',','.'));
        return grav;

    }

    public void carregarLista() {
        String titulos[] = {"Marca", "Nome", "Cor", "Portas", "Ano", "Preco", "Categoria", "Classe", "Alugado", "Placa"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) new VeiculoDAO().listarVeiculos();
        for (int i = 0; i < veiculos.size(); i++) {
            modelo.addRow(new Object[]{
                veiculos.get(i).getMarca(),
                veiculos.get(i).getNome(),
                veiculos.get(i).getCor(),
                veiculos.get(i).getPortas(),
                veiculos.get(i).getAno(),
                veiculos.get(i).getPreco(),
                veiculos.get(i).getCategoria(),
                veiculos.get(i).getClasse(),
                veiculos.get(i).getAlugado(),
                veiculos.get(i).getPlaca()
            });
        }
        tbCarros.setModel(modelo);
    }

    public Veiculo alugado() {
        Veiculo alugado = new Veiculo();
        alugado.setPlaca((txtPlacaPesq.getText()));
        //voto.setTitulo(Integer.parseInt(txtNumero.getText()));
        return alugado;
    }

    public Veiculo veiculos(Veiculo dados) {

        return dados;
    }

    public void listarMarcaClasse() {
        List<Veiculo> veiculos = dao.listarVeiculos();

        Veiculo can = new Veiculo();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Marca");
        model.addColumn("Cor");
        model.addColumn("Portas");
        model.addColumn("Ano");
        model.addColumn("Preço");
        model.addColumn("Categoria");
        model.addColumn("Classe");
        model.addColumn("Alugado");
        model.addColumn("Placa");

        for (int i = 0; i < veiculos.size(); i++) {
            model.addRow(new Object[]{
                veiculos.get(i).getMarca(),
                veiculos.get(i).getNome(),
                veiculos.get(i).getCor(),
                veiculos.get(i).getPortas(),
                veiculos.get(i).getAno(),
                veiculos.get(i).getPreco(),
                veiculos.get(i).getCategoria(),
                veiculos.get(i).getClasse(),
                veiculos.get(i).getAlugado(),
                veiculos.get(i).getPlaca()
            });
        }
    }

    public void veiculoEscolhido() {

        int linha = tbCarros.getSelectedRow();

        txtMarcaPesq.setText(tbCarros.getValueAt(linha, 0).toString());
        txtNomePesq.setText(tbCarros.getValueAt(linha, 1).toString());
        
        txtCorPesq.setText(tbCarros.getValueAt(linha, 2).toString());
        if (tbCarros.getValueAt(linha, 3).toString().equalsIgnoreCase("2")) {

            rd2portasP.setSelected(true);
        } else {

            rd4portasP.setSelected(true);

        }
        
        txtAnoPesq.setText(tbCarros.getValueAt(linha, 4).toString());
        txtPrecoPesq.setText(tbCarros.getValueAt(linha, 5).toString());
        if (tbCarros.getValueAt(linha, 6).toString().equalsIgnoreCase("Sedan")) {
            txtCategoriaPesq.setSelectedItem("Sedan");
        } else {
            txtCategoriaPesq.setSelectedItem("Hatch");
        }

        //txtCategoriaPesq.setText(tbCarros.getValueAt(linha, 5).toString());
        txtClassePesq.setText(tbCarros.getValueAt(linha, 7).toString());
        txtAlugadoPesq.setText(tbCarros.getValueAt(linha, 8).toString());
        txtPlacaPesq.setText(tbCarros.getValueAt(linha, 9).toString());

        txtMarcaC.setText(tbCarros.getValueAt(linha, 0).toString());
        txtNomeC.setText(tbCarros.getValueAt(linha, 1).toString());
        txtCorC.setText(tbCarros.getValueAt(linha, 2).toString());
        if (tbCarros.getValueAt(linha, 3).toString().equalsIgnoreCase("2")) {

            rd2portas.setSelected(true);
        } else {

            rd4portas.setSelected(true);

        }
        //txtPortasC.setText(tbCarros.getValueAt(linha, 2).toString());
        txtAnoC.setText(tbCarros.getValueAt(linha, 4).toString());
        txtValorC.setText(tbCarros.getValueAt(linha, 5).toString());

        if (tbCarros.getValueAt(linha, 6).toString().equalsIgnoreCase("Sedan")) {
            txtCategoriaC.setSelectedItem("Sedan");
        } else {
            txtCategoriaC.setSelectedItem("Hatch");
        }
        txtClasseC.setText(tbCarros.getValueAt(linha, 7).toString());

        txtPlacaC.setText(tbCarros.getValueAt(linha, 9).toString());

    }

    /* 
            (
                placa,
                marca,
                cor,
                portas,
                ano,
                preco,
                categoria,
                classe,
                alugado
            )
        }
        tbCarros.setModel(model);

    }

    public void buscarVeiculo() {

    }
            }

    //listarClasseMarca()
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCorC = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtAnoC = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCadastrarC = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        txtClasseC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtMarcaC = new javax.swing.JTextField();
        txtValorC = new javax.swing.JFormattedTextField();
        txtCategoriaC = new javax.swing.JComboBox<>();
        txtPlacaC = new javax.swing.JFormattedTextField();
        rd4portas = new javax.swing.JRadioButton();
        rd2portas = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        txtNomeC = new javax.swing.JTextField();
        btnCadastrarC1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCorPesq = new javax.swing.JTextField();
        txtAnoPesq = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCarros = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClassePesq = new javax.swing.JTextField();
        txtAlugadoPesq = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMarcaPesq = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPrecoPesq = new javax.swing.JFormattedTextField();
        txtCategoriaPesq = new javax.swing.JComboBox<>();
        txtPlacaPesq = new javax.swing.JTextField();
        txtNomePesq = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        rd4portasP = new javax.swing.JRadioButton();
        rd2portasP = new javax.swing.JRadioButton();
        btAlugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 30, 80, 80);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 46)); // NOI18N
        jLabel2.setText("Veículos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 30, 180, 80);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(10000, 32767));
        jTabbedPane1.setOpaque(true);

        jPanel3.setLayout(null);

        btnExcluir.setBackground(new java.awt.Color(204, 204, 204));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(btnExcluir);
        btnExcluir.setBounds(530, 230, 160, 25);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Classe:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(20, 100, 50, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Cor:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(20, 140, 50, 30);

        txtCorC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorCActionPerformed(evt);
            }
        });
        jPanel3.add(txtCorC);
        txtCorC.setBounds(70, 140, 120, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Ano:");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(20, 180, 50, 30);

        txtAnoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoCActionPerformed(evt);
            }
        });
        jPanel3.add(txtAnoC);
        txtAnoC.setBounds(70, 180, 120, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Placa: ");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(210, 140, 40, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Portas:");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(210, 100, 50, 30);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Categoria:");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(210, 20, 70, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Valor:");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(210, 180, 35, 30);
        jPanel3.add(jLabel11);
        jLabel11.setBounds(170, 270, 360, 180);

        btnCadastrarC.setBackground(new java.awt.Color(204, 204, 204));
        btnCadastrarC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastrarC.setText("Confirmar");
        btnCadastrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCActionPerformed(evt);
            }
        });
        jPanel3.add(btnCadastrarC);
        btnCadastrarC.setBounds(190, 230, 160, 25);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(360, 230, 160, 25);

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/InterDisciplinar/Logan.jpg"))); // NOI18N
        lblImagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblImagemKeyReleased(evt);
            }
        });
        jPanel3.add(lblImagem);
        lblImagem.setBounds(410, 20, 290, 0);

        txtClasseC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClasseC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClasseCActionPerformed(evt);
            }
        });
        txtClasseC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClasseCKeyPressed(evt);
            }
        });
        jPanel3.add(txtClasseC);
        txtClasseC.setBounds(70, 100, 120, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("YOU");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(260, 140, 40, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Marca:");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(20, 60, 50, 30);

        txtMarcaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaCActionPerformed(evt);
            }
        });
        jPanel3.add(txtMarcaC);
        txtMarcaC.setBounds(70, 60, 120, 30);

        try {
            txtValorC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtValorC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorCActionPerformed(evt);
            }
        });
        jPanel3.add(txtValorC);
        txtValorC.setBounds(280, 180, 100, 30);

        txtCategoriaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatch", "Sedan" }));
        txtCategoriaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaCActionPerformed(evt);
            }
        });
        jPanel3.add(txtCategoriaC);
        txtCategoriaC.setBounds(280, 20, 90, 30);

        try {
            txtPlacaC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPlacaC.setEnabled(false);
        txtPlacaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaCActionPerformed(evt);
            }
        });
        jPanel3.add(txtPlacaC);
        txtPlacaC.setBounds(310, 140, 70, 30);

        buttonGroup8.add(rd4portas);
        rd4portas.setText("4");
        jPanel3.add(rd4portas);
        rd4portas.setBounds(330, 100, 40, 30);

        buttonGroup8.add(rd2portas);
        rd2portas.setText("2");
        jPanel3.add(rd2portas);
        rd2portas.setBounds(280, 100, 40, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Nome:");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(20, 20, 50, 30);

        txtNomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCActionPerformed(evt);
            }
        });
        jPanel3.add(txtNomeC);
        txtNomeC.setBounds(70, 20, 120, 30);

        btnCadastrarC1.setBackground(new java.awt.Color(204, 204, 204));
        btnCadastrarC1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadastrarC1.setText("Novo");
        btnCadastrarC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarC1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCadastrarC1);
        btnCadastrarC1.setBounds(20, 230, 160, 25);

        jTabbedPane1.addTab("Cadastrar", jPanel3);

        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Classe:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 100, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cor:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Portas:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(210, 100, 50, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ano:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 180, 50, 30);

        txtCorPesq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorPesq.setEnabled(false);
        txtCorPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorPesqActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorPesq);
        txtCorPesq.setBounds(70, 140, 120, 30);

        txtAnoPesq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAnoPesq.setEnabled(false);
        txtAnoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoPesqActionPerformed(evt);
            }
        });
        jPanel1.add(txtAnoPesq);
        txtAnoPesq.setBounds(70, 180, 120, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Categoria:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(210, 20, 70, 30);

        tbCarros.setAutoCreateRowSorter(true);
        tbCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Nome", "Cor", "Portas", "Ano", "Preço", "Categoria", "Classe", "Alugado", "Placa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCarros.getTableHeader().setReorderingAllowed(false);
        tbCarros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCarrosMouseClicked(evt);
            }
        });
        tbCarros.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbCarrosCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tbCarros);
        if (tbCarros.getColumnModel().getColumnCount() > 0) {
            tbCarros.getColumnModel().getColumn(0).setResizable(false);
            tbCarros.getColumnModel().getColumn(1).setResizable(false);
            tbCarros.getColumnModel().getColumn(2).setResizable(false);
            tbCarros.getColumnModel().getColumn(3).setResizable(false);
            tbCarros.getColumnModel().getColumn(4).setResizable(false);
            tbCarros.getColumnModel().getColumn(5).setResizable(false);
            tbCarros.getColumnModel().getColumn(6).setResizable(false);
            tbCarros.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 230, 690, 210);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Alugado:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(210, 60, 60, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Valor:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(210, 180, 35, 30);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 20, 290, 190);

        txtClassePesq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClassePesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassePesqActionPerformed(evt);
            }
        });
        txtClassePesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClassePesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClassePesqKeyReleased(evt);
            }
        });
        jPanel1.add(txtClassePesq);
        txtClassePesq.setBounds(70, 100, 120, 30);

        txtAlugadoPesq.setEnabled(false);
        jPanel1.add(txtAlugadoPesq);
        txtAlugadoPesq.setBounds(280, 60, 90, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Placa:");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(210, 140, 36, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("YOU");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 140, 40, 30);

        txtMarcaPesq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMarcaPesq.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                txtMarcaPesqComponentRemoved(evt);
            }
        });
        txtMarcaPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaPesqActionPerformed(evt);
            }
        });
        txtMarcaPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMarcaPesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaPesqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaPesqKeyTyped(evt);
            }
        });
        jPanel1.add(txtMarcaPesq);
        txtMarcaPesq.setBounds(70, 60, 120, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Marca:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 60, 50, 30);

        txtPrecoPesq.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtPrecoPesq.setEnabled(false);
        txtPrecoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoPesqActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecoPesq);
        txtPrecoPesq.setBounds(270, 180, 100, 30);

        txtCategoriaPesq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatch", "Sedan" }));
        txtCategoriaPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaPesqActionPerformed(evt);
            }
        });
        jPanel1.add(txtCategoriaPesq);
        txtCategoriaPesq.setBounds(280, 20, 90, 30);

        txtPlacaPesq.setEnabled(false);
        jPanel1.add(txtPlacaPesq);
        txtPlacaPesq.setBounds(300, 140, 70, 30);

        txtNomePesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePesqActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomePesq);
        txtNomePesq.setBounds(70, 20, 120, 30);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Nome:");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(20, 20, 50, 30);

        buttonGroup9.add(rd4portasP);
        rd4portasP.setText("4");
        jPanel1.add(rd4portasP);
        rd4portasP.setBounds(330, 100, 40, 25);

        buttonGroup9.add(rd2portasP);
        rd2portasP.setText("2");
        jPanel1.add(rd2portasP);
        rd2portasP.setBounds(280, 100, 40, 25);

        jTabbedPane1.addTab("Consultar", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 120, 740, 500);

        btAlugar.setBackground(new java.awt.Color(204, 204, 204));
        btAlugar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAlugar.setText("Alugar");
        btAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlugarActionPerformed(evt);
            }
        });
        getContentPane().add(btAlugar);
        btAlugar.setBounds(20, 630, 740, 50);

        setBounds(0, 0, 799, 743);
    }// </editor-fold>//GEN-END:initComponents

    private void lblImagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblImagemKeyReleased
        // ImageIcon imagemIcon = new ImageIcon(new ImageIcon("C:/imagens"+txtMarcaC.getText()).getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT));
        // lblImagem.setIcon(imagemIcon);
        //
        // ImageIcon imagemIcon = new ImageIcon(new ImageIcon().getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT));
        // if(txtMarcaC.getText()=="Logan"){
        //     lblImagem.setIcon(imagemIcon);
        // }
        //
        // lblImagem.setIcon(imagemIcon);
        // ImageIcon imagemIcon = new ImageIcon(new ImageIcon("C:\\imagens\\Logan2.jpg").getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
        // lblImagem.setIcon(imagemIcon);

    }//GEN-LAST:event_lblImagemKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int placa = JOptionPane.showConfirmDialog(null, "Deseja altrar a placa?");
        if(placa==JOptionPane.YES_OPTION){
            txtPlacaC.setEnabled(true);
           // if();
            
            
        String func = new VeiculoDAO().alterarVeiculo(gravaVeiculo());
        if (func == "OK") {
            
            //JOptionPane.showMessageDialog(null, "Veiculo Alterado!!!");
            carregarLista();
            txtPlacaC.setEnabled(false);
           // String func = new VeiculoDAO().alterarVeiculo(gravaVeiculo());
        } else {
            JOptionPane.showMessageDialog(null, func);
        }
        } else {
            String func = new VeiculoDAO().alterarVeiculo(gravaVeiculo());
        if (func == "OK") {
            JOptionPane.showMessageDialog(null, "Veiculo Alterado!!!");
            carregarLista();
            //txtPlacaC.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, func);
        }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCadastrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCActionPerformed
        //String cadastrar = new  VeiculoDAO().gravarVeiculo(gravaVeiculo());
        //String placa = txtPlacaC.getText();

        //Veiculo vei = new VeiculoDAO().pegaVeiculo(txtPlacaC.toString());
        //if(cadastrar=="OK"){
        //    JOptionPane.showMessageDialog(null, "veiculo de placa "+placa+" cadastrado");
        //} else{
        //    JOptionPane.showMessageDialog(null, vei);
        //}
        Veiculo gravar = gravaVeiculo();
        String resp = new VeiculoDAO().gravarVeiculo(gravar);
        if (resp == "OK") {
            JOptionPane.showMessageDialog(null, "Veiculo de placa " + txtPlacaC.getText() + " Cadastrado");
            System.out.println(resp);
        }

        /*DadosUrna gravarr = gravarEleitor();
        String resp = new EleitorDAO().gravarEleitor(gravarr);
        if(resp=="OK"){
            System.out.println(resp);
        }*/
        //gravarVeiculo();
    }//GEN-LAST:event_btnCadastrarCActionPerformed

    private void txtAnoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoCActionPerformed

    private void txtCorCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorCActionPerformed

    private void txtMarcaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaCActionPerformed
        // ImageIcon img = new ImageIcon(new ImageIcon("C:\\imagens"+txtMarcaC.getText()).getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT));
        //lblImagemCarro.setIcon(img);

        //ImageIcon img = new ImageIcon(new ImageIcon("c:/imagens/"+txtMarcaC.getText()+".jpg").getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT));
        //lblImagemCarro.setIcon(img);
        //ImageIcon img = new ImageIcon(new ImageIcon("c:/imagem/"+txtMarcaC.getText()+".PGN").getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT));
        //lblImagem.setIcon(imagemIcon);
        // ImageIcon imagemIcon = new ImageIcon(new ImageIcon("c:/imagens/" + txtMarcaC.getText()).getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
        //lblImagem.setIcon(imagemIcon);

        /*Logo3 l = new Logo();
        if(txtMarca.getText()=="Rnalt"){
            lblImagemCarro.setIcon(Logo3());
        }
         */
    }//GEN-LAST:event_txtMarcaCActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String veic = new VeiculoDAO().excluirVeiculo(gravaVeiculo());
        if (veic == "OK") {
            JOptionPane.showMessageDialog(null, "Veiculo Excuido!!!");
        } else {

            JOptionPane.showMessageDialog(null, veic);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlugarActionPerformed

        Veiculo vei = new Veiculo();
        vei.setMarca(txtMarcaPesq.getText());
        vei.setNome(txtNomePesq.getText());
        vei.setPlaca(txtPlacaPesq.getText());
        if (txtCategoriaPesq.getActionCommand() == "Sedan"){
            vei.setCategoria("Sedan");
            // txtCategoriaPesq.setSelectedItem("Sedan");
        } else {
            vei.setCategoria("Hatch");
            // txtCategoriaPesq.setSelectedItem("Hatch");
        }
        vei.setClasse(txtClassePesq.getText());
        vei.setAno(txtAnoPesq.getText());
        vei.setPreco(Float.parseFloat(txtPrecoPesq.getText()));
        vei.setCor(txtCorPesq.getText());
        if(rd2portasP.isSelected()){
            vei.setPortas("2");
        } else {
            vei.setPortas("4");
        }
        

        janelaCliente.enviaAlugado(vei);
        janelaCliente.setVisible(true);

        if (!txtPlacaPesq.getText().isEmpty()) {
            if (janelaCliente == null) {
                janelaCliente = new frmClientes();
                janelaCliente.setLocationRelativeTo(null);
                janelaCliente.setVisible(true);
                janelaCliente.setResizable(false);

            } else {
                janelaCliente.setLocationRelativeTo(null);
                janelaCliente.setVisible(true);
                janelaCliente.setResizable(false);
            }

        }

        String res = new VeiculoDAO().updateAlugado(alugado());
        if (res == "OK" || btAlugar.isSelected()) {
            alugado();
            JOptionPane.showMessageDialog(null, "Excelente Escolha!!");
        } else {
            JOptionPane.showMessageDialog(null, res);
        }
    }//GEN-LAST:event_btAlugarActionPerformed

    private void txtClassePesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassePesqKeyPressed
        /*if(txtClassePesq.getText()=="A"){
            btClasseA.setSelected(true);
        } else if(txtClassePesq.getText().equals("B")){
            btClasseB.setSelected(true);
        } else{btClasseC.setSelected(true);
        }*/
    }//GEN-LAST:event_txtClassePesqKeyPressed

    private void txtClassePesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassePesqActionPerformed
        /*           
            txtClassePesq.setText(txtClassePesq.getText()+"9");
            frmVeiculos vei = new VeiculoDAO().buscaVeiculo(txtClassePesq.setText());
            tbCarros.setModel(vei.getClasse());
         */

        //buscaVeiculo
    }//GEN-LAST:event_txtClassePesqActionPerformed

    private void tbCarrosCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbCarrosCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCarrosCaretPositionChanged

    private void tbCarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCarrosMouseClicked
        veiculoEscolhido();

//Object port;
        //btPortas2.setEnabled(true);
        //btClass

    }//GEN-LAST:event_tbCarrosMouseClicked

    private void txtAnoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoPesqActionPerformed

    private void txtCorPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorPesqActionPerformed

    private void txtMarcaPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaPesqActionPerformed
        if (txtMarcaPesq.getText().toString() == "") {
            carregarLista();
        }
    }//GEN-LAST:event_txtMarcaPesqActionPerformed

    private void txtClasseCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasseCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasseCActionPerformed

    private void txtClasseCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClasseCKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasseCKeyPressed

    private void txtMarcaPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaPesqKeyReleased

        Veiculo marcaClasse = garavaMarcaClasse();

        List<Veiculo> veiculos = dao.pegaCarrosMarca(marcaClasse, marcaClasse, marcaClasse);
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Marca");
        model.addColumn("Nome");
        model.addColumn("Cor");
        model.addColumn("Portas");
        model.addColumn("Ano");
        model.addColumn("Preço");
        model.addColumn("Categoria");
        model.addColumn("Classe");
        model.addColumn("Alugado");
        model.addColumn("Placa");

        for (int i = 0; i < veiculos.size(); i++) {
            model.addRow(new Object[]{
                veiculos.get(i).getMarca(),
                veiculos.get(i).getNome(),
                veiculos.get(i).getCor(),
                veiculos.get(i).getPortas(),
                veiculos.get(i).getAno(),
                veiculos.get(i).getPreco(),
                veiculos.get(i).getCategoria(),
                veiculos.get(i).getClasse(),
                veiculos.get(i).getAlugado(),
                veiculos.get(i).getPlaca()
            });
        }
        tbCarros.setModel(model);


    }//GEN-LAST:event_txtMarcaPesqKeyReleased

    private void txtClassePesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassePesqKeyReleased
        Veiculo marcaClasse = garavaMarcaClasse();

        List<Veiculo> veiculos = dao.pegaCarrosMarca(marcaClasse, marcaClasse, marcaClasse);
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Marca");
        model.addColumn("Nome");
        model.addColumn("Cor");
        model.addColumn("Portas");
        model.addColumn("Ano");
        model.addColumn("Preço");
        model.addColumn("Categoria");
        model.addColumn("Classe");
        model.addColumn("Alugado");
        model.addColumn("Placa");

        for (int i = 0; i < veiculos.size(); i++) {
            model.addRow(new Object[]{
                veiculos.get(i).getMarca(),
                veiculos.get(i).getNome(),
                veiculos.get(i).getCor(),
                veiculos.get(i).getPortas(),
                veiculos.get(i).getAno(),
                veiculos.get(i).getPreco(),
                veiculos.get(i).getCategoria(),
                veiculos.get(i).getClasse(),
                veiculos.get(i).getAlugado(),
                veiculos.get(i).getPlaca()
            });
        }
        tbCarros.setModel(model);

    }//GEN-LAST:event_txtClassePesqKeyReleased

    private void txtPrecoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoPesqActionPerformed

    private void txtCategoriaPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaPesqActionPerformed

    private void txtValorCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCActionPerformed

    private void txtMarcaPesqComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtMarcaPesqComponentRemoved

    }//GEN-LAST:event_txtMarcaPesqComponentRemoved

    private void txtMarcaPesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaPesqKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaPesqKeyPressed

    private void txtMarcaPesqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaPesqKeyTyped

    }//GEN-LAST:event_txtMarcaPesqKeyTyped

    private void txtCategoriaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaCActionPerformed

    private void txtPlacaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaCActionPerformed

    private void txtNomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCActionPerformed

    private void txtNomePesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePesqActionPerformed

    private void btnCadastrarC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarC1ActionPerformed
        
    }//GEN-LAST:event_btnCadastrarC1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlugar;
    private javax.swing.JButton btnCadastrarC;
    private javax.swing.JButton btnCadastrarC1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JRadioButton rd2portas;
    private javax.swing.JRadioButton rd2portasP;
    private javax.swing.JRadioButton rd4portas;
    private javax.swing.JRadioButton rd4portasP;
    private javax.swing.JTable tbCarros;
    private javax.swing.JTextField txtAlugadoPesq;
    private javax.swing.JTextField txtAnoC;
    private javax.swing.JTextField txtAnoPesq;
    private javax.swing.JComboBox<String> txtCategoriaC;
    private javax.swing.JComboBox<String> txtCategoriaPesq;
    private javax.swing.JTextField txtClasseC;
    private javax.swing.JTextField txtClassePesq;
    private javax.swing.JTextField txtCorC;
    private javax.swing.JTextField txtCorPesq;
    private javax.swing.JTextField txtMarcaC;
    private javax.swing.JTextField txtMarcaPesq;
    private javax.swing.JTextField txtNomeC;
    private javax.swing.JTextField txtNomePesq;
    private javax.swing.JFormattedTextField txtPlacaC;
    private javax.swing.JTextField txtPlacaPesq;
    private javax.swing.JFormattedTextField txtPrecoPesq;
    private javax.swing.JFormattedTextField txtValorC;
    // End of variables declaration//GEN-END:variables

}
