<%@ attribute name="id" required="true" %>
<%@ attribute name="val" required="false" %>
<input type="text" id="${id}" name="${id}" value="${val}" />
<script type="text/javascript">
/*  Inicializa DatePicker com opção de trocar o ano, no intervalo 1940 a 2000 e no formato dd/mm/yy */
    $("#${id}").datepicker({ changeYear: true , yearRange: "1940:2000", dateFormat:'dd/mm/yy' });
/*  Getter do  DatePicker utilizando as opçoes que foram inicializadas acima                        */
    var changeYear = $("#${id}").datepicker( "option", "changeYear", "yearRange" );
/*  Obtem a Data formatada a partir do DatePicker conforme as opções selecionadas                   */
    $("#${id}").datepicker( );
</script>