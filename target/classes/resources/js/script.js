const body = document.querySelector('body'),
    sidebar = body.querySelector('.sidebar'),
    toggle = body.querySelector('.toogle');


toggle.addEventListener('click', () => {
    sidebar.classList.toggle('close');
});