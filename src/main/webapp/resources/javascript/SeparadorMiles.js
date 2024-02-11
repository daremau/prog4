/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function SeparadorMiles(input) {

    let value = input.value.replace(/[^0-9.]/g, '');

    let parts = value.split('.');
    let integerPart = parts[0];
    let fractionalPart = parts.length > 1 ? '.' + parts[1] : '';

    integerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ',');

    input.value = integerPart + fractionalPart;

    input.onfocus = function() {
    value = value.replace(/,/g, '');
    value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    input.value = value;
    };

    input.onblur = function() {
        value = value.replace(/,/g, '');
        input.value = value;
    };
}
