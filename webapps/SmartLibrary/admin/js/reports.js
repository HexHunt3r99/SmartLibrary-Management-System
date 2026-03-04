new Chart(document.getElementById('borrowChart').getContext('2d'), {
    type: 'line',
    data: {
        labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
        datasets: [{ label: 'Borrows', data: [320, 450, 380, 373], borderColor: '#4A90D9', fill: true, backgroundColor: 'rgba(74,144,217,0.1)', tension: 0.4 }]
    },
    options: { responsive: true, maintainAspectRatio: false, plugins: { legend: { position: 'top' } }, scales: { y: { beginAtZero: true } } }
});
new Chart(document.getElementById('categoryChart').getContext('2d'), {
    type: 'doughnut',
    data: {
        labels: ['Programming', 'Science', 'Mathematics', 'History', 'Literature'],
        datasets: [{ data: [423, 312, 256, 198, 167], backgroundColor: ['#4A90D9', '#10B981', '#F59E0B', '#7C3AED', '#EF4444'] }]
    },
    options: { responsive: true, maintainAspectRatio: false, plugins: { legend: { position: 'bottom' } } }
});
